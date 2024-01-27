import React, { useState ,useEffect} from 'react';
import Modal from 'react-modal';import Multiselect from 'multiselect-react-dropdown';
import axios from 'axios';
Modal.setAppElement('#root'); // Make sure to set your root element as the app element
function EditModal({ isOpen, onRequestClose, onSave, data }) {
  const [editedData, setEditedData] = useState(data);
  const [newRow, setNewRow] = useState({  name: '', role: '',password:'',ids:''  });
  const[state,setState]=useState([]);
  const [selectedValue,setSelectedValue]=useState([]);
  const [data1, setData1] = useState([]);
  console.log(data.id)
  useEffect(() => {
    
    axios.get('http://localhost:8082/devices/devicess')
      .then((response) => {
        
        setData1(response.data); // Use response.data to update the state
        console.log(response.data); // Log the data received from the server
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
        console.log("bbb");
      });
  }, []);
  const handleChange = (e) => {
    const { name, value } = e.target;
    setEditedData({
      ...editedData,
      [name]: value,
    });
  };
  
  const onSelect=(selectedList, selectedItem)=> {
    setSelectedValue(selectedList);
  }

  const onRemove=(selectedList, removedItem)=> {
    setSelectedValue(selectedList);
  }
  const handleSave1 = () => {
    const  idsArray=selectedValue.map((item) => item.id); 
   console.log(idsArray)
    axios.post('http://localhost:8081/accounts',{name:editedData.name,
    role:editedData.role,
    password:editedData.password,
    devicesIds:idsArray})
      .then((response) => {
        setEditedData([...data, newRow]);
        setNewRow({ name: '', role: '',password:'',ids:[] });
      })
      .catch((error) => {
        console.error('Error saving data:', error);
        // Handle any errors here
      });
  };
  const handleEdit = () => {
    const  idsArray=selectedValue.map((item) => item.id);
    console.log("Avem aici"+idsArray)
    axios.put(`http://localhost:8081/accounts/${data.id}`,{name:editedData.name,
    role:editedData.role,
    password:editedData.password,
    devicesIds:idsArray})
      .then((response) => {
      const updatedData = [...data];
      const editedIndex = updatedData.findIndex((item) => item.id === data.id);
      if (editedIndex !== -1) {
        updatedData[editedIndex] = {
          ...updatedData[editedIndex],
          name: editedData.name,
          role: editedData.role,
          password: editedData.password,
          ids: idsArray,
        };
      }

      setEditedData(updatedData);
    })
      .catch((error) => {
        console.error('Error saving data:', error);
        // Handle any errors here
      });
  };
  return (
    <Modal
      isOpen={isOpen}
      onRequestClose={onRequestClose}
      contentLabel="Edit Employee"
    >
      <h2>Edit Employee</h2>
      <form>
        <div>
          <label htmlFor="name">Name:</label>
          <input
            type="text"
            id="name"
            name="name"
            value={editedData.name}
            onChange={handleChange}
          />
        </div>
        <div>
          <label htmlFor="role">Role:</label>
          <input
            type="number"
            id="role"
            name="role"
            value={editedData.role}
            onChange={handleChange}
          />
        </div>
        <div>
          <label htmlFor="password">Password:</label>
          <input
            type="password"
            id="password"
            name="password"
            value={editedData.password}
            onChange={handleChange}
          />
        </div>
        <div>
          <label htmlFor="ids">Ids:</label>
          <Multiselect
            options={data1 && data1.map((item) => ({ name: item.toString(), id: item }))}
            selectedValues={selectedValue} // Preselected value to persist in dropdown
            onSelect={onSelect} // Function will trigger on select event
            onRemove={onRemove} // Function will trigger on remove event
            displayValue="name" // Property name to display in the dropdown options
          />
        </div>
        <button onClick={handleSave1}>Save</button>
        <button onClick={handleEdit}>Edit</button>
        <button onClick={onRequestClose}>Cancel</button>
      </form>
    </Modal>
  );
}

export default EditModal;