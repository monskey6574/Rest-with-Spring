import React, { useState, useEffect } from "react";
import axios from "axios";

const API_URL = "http://localhost:8080/api/v1"; // Replace with your backend URL

function App() {
  const [users, setUsers] = useState([]);
  const [form, setForm] = useState({ id: "", name: "", email: "" });
  const [editing, setEditing] = useState(false);

  // Fetch all users
  const fetchUsers = async () => {
    try {
      const response = await axios.get(`${API_URL}/users`);
      setUsers(response.data);
    } catch (error) {
      console.error("Error fetching users:", error);
    }
  };

  // Create or Update User
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (editing) {
        // Update user
        await axios.put(`${API_URL}/${form.id}`, form);
        alert("User updated successfully!");
      } else {
        // Create new user
        await axios.post(`${API_URL}/adduser`, form);
        alert("User added successfully!");
      }
      setForm({ id: "", name: "", email: "" });
      setEditing(false);
      fetchUsers();
    } catch (error) {
      console.error("Error saving user:", error);
    }
  };

  // Delete User
  const handleDelete = async (id) => {
    try {
      await axios.delete(`${API_URL}/${id}`);
      alert("User deleted successfully!");
      fetchUsers();
    } catch (error) {
      console.error("Error deleting user:", error);
    }
  };

  // Edit User
  const handleEdit = (user) => {
    setForm(user);
    setEditing(true);
  };

  // Load users on component mount
  useEffect(() => {
    fetchUsers();
  }, []);

  return (
    <div className="App">
      <h1>User Management</h1>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="ID"
          value={form.id}
          onChange={(e) => setForm({ ...form, id: e.target.value })}
          required
        />
        <input
          type="text"
          placeholder="Name"
          value={form.name}
          onChange={(e) => setForm({ ...form, name: e.target.value })}
          required
        />
        <input
          type="email"
          placeholder="Email"
          value={form.email}
          onChange={(e) => setForm({ ...form, email: e.target.value })}
          required
        />
        <button type="submit">{editing ? "Update User" : "Add User"}</button>
      </form>

      <h2>Users</h2>
      {users.length > 0 ? (
        <ul>
          {users.map((user) => (
            <li key={user.id}>
              {user.id} - {user.name} ({user.email})
              <button onClick={() => handleEdit(user)}>Edit</button>
              <button onClick={() => handleDelete(user.id)}>Delete</button>
            </li>
          ))}
        </ul>
      ) : (
        <p>No users found.</p>
      )}
    </div>
  );
}

export default App;
