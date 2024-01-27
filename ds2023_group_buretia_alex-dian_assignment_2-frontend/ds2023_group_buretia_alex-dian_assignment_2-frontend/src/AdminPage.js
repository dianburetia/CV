import React, { useEffect, useState } from 'react';
import axios from 'axios';
import EditModal from './EditModal.js';
import EditModalDevice from './EditModalDevice.js';
function AdminPage() {
  const [data, setData] = useState([]);
  const [dataDevice, setDataDevice] = useState([]);
  const [newData, setNewData] = useState({ id: '', name: '', role: '' });
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [isModalOpenDevice, setIsModalOpenDevice] = useState(false);
  const [editedRow, setEditedRow] = useState({ id: '', name: '', role: '' });
  const [editedRowDevice, setEditedRowDevice] = useState({ descriptions: '', address: '', maximumConsumption: '',accountId:'' });
  useEffect(() => {
    axios.get('http://localhost:8081/accounts')
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });

      axios.get('http://localhost:8082/devices')
      .then((response) => {
        setDataDevice(response.data);
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });
  }, []);
  const handleEdit = (index) => {
    setEditedRow(data[index]);
    setIsModalOpen(true);
  };
  const handleEditDevice=(indexDevice)=>{
    setEditedRowDevice(dataDevice[indexDevice]);
    setIsModalOpenDevice(true);
  }
  const handleAdd = (index) => {
    //setEditedRow(data[index]);
    
    setIsModalOpen(true);
  };
  const handleAddDevice=(indexDevice)=>{
    console.log("am intraaaaaat");setEditedRowDevice(data[indexDevice]);
    setIsModalOpenDevice(true);
    console.log(isModalOpenDevice)
  }
  const handleDelete = (index) => {
    setEditedRow(data[index]);
    console.log(data[index].id)
    axios.delete(`http://localhost:8087/accounts/${data[index].id}`)
    .then((response) => {
      setData(response.data);
    })
    .catch((error) => {
      console.error('Error fetching data:', error);
    });
    axios.get('http://localhost:8087/accounts')
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });
    //setIsModalOpenDevice(true);
    //setIsModalOpen(false);
  };
  const handleDeleteDevice = (indexDevice) => {
    setEditedRowDevice(dataDevice[indexDevice]);
    axios.delete(`http://localhost:8082/devices/${dataDevice[indexDevice].id}`)
    .then((response) => {
      setData(response.data);
    })
    .catch((error) => {
      console.error('Error fetching data:', error);
    });
    axios.get('http://localhost:8082/devices')
      .then((response) => {
        setDataDevice(response.data);
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });
    // axios.delete('http://localhost:8091/accounts',index)
    // .then((response) => {
    //   setData(response.data);
    // })
    // .catch((error) => {
    //   console.error('Error fetching data:', error);
    // });
    //setIsModalOpenDevice(true);
  };
  const handleModalClose = () => {
    setIsModalOpen(false);
  };
  const handleModalCloseDevice = () => {
    //setIsModalOpenDevice(false);
  };
  const handleModalSave = (updatedData) => {
    // Implement save logic to update the row
    // You can send a request to the backend with the updated data
    // Then, update the data array and close the modal
    setIsModalOpen(false);
  };
  const handleModalSaveDevice = (updatedData) => {
    // Implement save logic to update the row
    // You can send a request to the backend with the updated data
    // Then, update the data array and close the modal
    setIsModalOpenDevice(false);
  };
  return (
    <div>
      <h1>Users Table</h1>
      <button onClick={handleAdd}>Add</button>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Role</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {data.map((row, index) => (
            <tr key={row.id}>
              <td>{row.id}</td>
              <td>{row.name}</td>
              <td>{row.role}</td>
              <td>
                <button onClick={() => handleEdit(index)}>Edit</button>
                <button onClick={() => handleDelete(index)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <EditModal
        isOpen={isModalOpen}
        onRequestClose={handleModalClose}
        onSave={handleModalSave}
        data={editedRow}
      />
      <h1>Device Table</h1>
      <button onClick={handleAddDevice}>Add</button>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Descriptions</th>
            <th>Address</th>
            <th>MaximumConsumption</th>
            <th>AccountId</th>
          </tr>
        </thead>
        <tbody>
          {dataDevice.map((row, index) => (
            <tr key={row.id}>
              <td>{row.id}</td>
              <td>{row.descriptions}</td>
              <td>{row.address}</td>
              <td>{row.maximumConsumption}</td>
              <td>{row.accountId}</td>
              <td>
                <button onClick={() => handleEditDevice(index)}>Edit</button>
                <button onClick={() => handleDeleteDevice(index)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <EditModalDevice
        isOpenDevice={isModalOpenDevice}
        onRequestCloseDevice={handleModalCloseDevice}
        onSave={handleModalSaveDevice}
        dataDevice={editedRowDevice}
      />
      {/* <EditModal
        isOpen={isModalOpenDevice}
        onRequestClose={handleModalCloseDevice}
        onSave={handleModalSaveDevice}
        data={editedRow}
      /> */}
  </div>
  );
}
export default AdminPage;