import React, { useState ,useEffect} from 'react';
import Modal from 'react-modal';
import axios from 'axios';
import Select from 'react-select'
Modal.setAppElement('#root'); // Make sure to set your root element as the app element 
function EditModalDevice({ isOpenDevice, onRequestCloseDevice, onSave, dataDevice }) {
  const [editedData1, setEditedData1] = useState(dataDevice);
  const [newRow, setNewRow] = useState({  descriptions: '', address: '',maximumConsumption:'',accountId:''  });
  const[state,setState]=useState([]);
  const [selectedValue,setSelectedValue]=useState(null);
  const[isOpenDeviceState,setIsOpenDeviceState]=useState(isOpenDevice);
  const [data1, setData1] = useState([]);
  useEffect(() => {
    axios.get('http://localhost:8081/accounts/accounts')
      .then((response) => {
        setData1(response.data);
        console.log(data1);
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });
      console.log("avem aici"+selectedValue)

  }, []);
  const handleChange = (e) => {
    const { name, value } = e.target;
    setEditedData1({
      ...editedData1,
      [name]: value,
    });
  };
  const onChange=( selectedItem)=> {
    setSelectedValue(selectedItem);
  }

  
  //console.log("aaam o casuta "+dataDevice.id)
  const handleEdit1 = () => {
    axios.put(`http://localhost:8082/devices/${dataDevice.id}`,{descriptions:editedData1.descriptions,
    address:editedData1.address,
    maximumConsumption:editedData1.maximumConsumption,
    accountId:selectedValue.value})
      .then((response) => {
        setEditedData1([...dataDevice, newRow]);
        setNewRow({ decriptions: '', address: '',maximumConsumption:'',accountId:'' });
       })
      .catch((error) => {
        console.error('Error saving data:', error);
        // Handle any errors here
      });
  };
  
  const handleSave1 = () => {
    console.log("Descriptions are"+selectedValue)
    axios.post('http://localhost:8082/devices',{
    descriptions:editedData1.descriptions,
    address:editedData1.address,
    maximumConsumption:editedData1.maximumConsumption,
    accountId:selectedValue.value})
      .then((response) => {
        setEditedData1(response.data); // Update the edited data
        onRequestCloseDevice(); // Close the modal after editing
      })
      .catch((error) => {
        console.error('Error saving data:', error);
      });
  };
    return (
    <div>
    <Modal
      isOpen={isOpenDevice}
      onRequestClose={onRequestCloseDevice}
      contentLabel="Edit Employee"
    >
      <h2>Edit Device</h2>
      <form>
        <div>
          <label htmlFor="descriptions">Descriptions:</label>
          <input
            type="text"
            id="descriptions"
            name="descriptions"
            value={editedData1.descriptions}
            onChange={handleChange}
          />
        </div>
        <div>
          <label htmlFor="address">Address:</label>
          <input
            type="text"
            id="address"
            name="address"
            value={editedData1.address}
            onChange={handleChange}
          />
        </div>
        <div>
          <label htmlFor="maximumConsumption">Maximum Consumption:</label>
          <input
            type="decimal"
            id="maximumConsumption"
            name="maximumConsumption"
            value={editedData1.maximumConsumption}
            onChange={handleChange}
          />
        </div>
        <div>
          <label htmlFor="accountId">Account Id:</label>
          <Select
            options={data1 && data1.map((item) => ({ label: item.toString(), value: item }))}
            //selectedValue={selectedValue} // Preselected value to persist in dropdown
            onChange={(selectedOption) => setSelectedValue(selectedOption)}
            // displayValue="label" // Property name to display in the dropdown options
            // isMulti={false} // Assuming you want to select only one value
          />
        </div>
        <button onClick={handleSave1}>Save</button>
        <button onClick={handleEdit1}>Edit</button>
        <button onClick={onRequestCloseDevice}>Cancel</button>
      </form>
    </Modal>
    </div>
  );
}

export default EditModalDevice;