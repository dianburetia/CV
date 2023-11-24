import React,{useState} from 'react';
import axios from 'axios';
function DeviceTable({ devices }) {
  const [isEditModalOpen, setIsEditModalOpen] = useState(false);
  const [editedDevice, setEditedDevice] = useState(null);
  const handleSave1 = () => {
    
    axios.put(`http://localhost:8091/accounts/devices/${editedDevice.id}`,{
    id:editedDevice.id,
    descriptions:editedDevice.descriptions,
    address:editedDevice.address,
    maximumConsumption:editedDevice.maximumConsumption,
    accountId:editedDevice.accountid})
      .then((response) => {
        setEditedDevice(response.data); // Update the edited data
        
      })
      .catch((error) => {
        console.error('Error saving data:', error);
      });
  };
  // Event handler to open the edit modal
  const openEditModal = (device) => {
    setIsEditModalOpen(true);
    setEditedDevice(device);
  };

  // Event handler to close the edit modal
  const closeEditModal = () => {
    setIsEditModalOpen(false);
    setEditedDevice(null);
  };

  // Event handler to update the edited device
  const handleEdit = (e) => {
    e.preventDefault();
    // Perform the edit action (e.g., make an API request)
    // After successful edit, update the state and close the modal
    // You should replace the following code with your actual edit logic
    console.log('Edited device:', editedDevice);
    closeEditModal();
  };
  return (
    <div>
      <h2>Devices</h2>
      <table>
        <thead>
          <tr>
            <th>Device ID</th>
            <th>Descriptions</th>
            <th>Address</th>
            <th>Maximum Consumption</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {devices ? (
            devices.map((device) => (
              <tr key={device.id}>
                <td>{device.id}</td>
                <td>{device.descriptions}</td>
                <td>{device.address}</td>
                <td>{device.maximumConsumption}</td>
                <td>
                  <button onClick={() => openEditModal(device)}>Edit</button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="5">No devices available.</td>
            </tr>
          )}
        </tbody>
      </table>

      {isEditModalOpen && (
        <div className="modal">
          <div className="modal-content">
            <span className="close" onClick={closeEditModal}>
              &times;
            </span>
            <h2>Edit Device</h2>
            <form onSubmit={handleEdit}>
              <label>Device ID:</label>
              <input
                type="text"
                name="id"
                value={editedDevice.id}
                onChange={(e) =>
                  setEditedDevice({ ...editedDevice, id: e.target.value })
                }
              />
              <label>Descriptions:</label>
              <input
                type="text"
                name="descriptions"
                value={editedDevice.descriptions}
                onChange={(e) =>
                  setEditedDevice({
                    ...editedDevice,
                    descriptions: e.target.value,
                  })
                }
              />
              <label>Address:</label>
              <input
                type="text"
                name="address"
                value={editedDevice.address}
                onChange={(e) =>
                  setEditedDevice({ ...editedDevice, address: e.target.value })
                }
              />
              <label>Maximum Consumption:</label>
              <input
                type="text"
                name="maximumConsumption"
                value={editedDevice.maximumConsumption}
                onChange={(e) =>
                  setEditedDevice({
                    ...editedDevice,
                    maximumConsumption: e.target.value,
                  })
                }
              />
              <label>IdAccount:</label>
              <input
                type="number"
                name="accountid"
                value={editedDevice.accountid}
                onChange={(e) =>
                  setEditedDevice({ ...editedDevice, accountid: e.target.value })
                }
              />
              <button type="submit" onClick={handleSave1}>Save</button>
            </form>
          </div>
        </div>
      )}
    </div>
  );
}

export default DeviceTable;