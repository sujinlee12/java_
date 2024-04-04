import './App.css';
import { useState } from 'react';
import { BrowserRouter, Route, Link, Routes, useLocation, useNavigate } from 'react-router-dom';

function App() {

  let [list, setList] = useState([]);
  

  function add(music) {
    setList([music, ...list]);
  }
  function remove(id) {
    let tmpList = list.filter(item => item.id != id);
    setList(tmpList);
  }
  return (
    <BrowserRouter>
      <Nav />
      <Routes>
        <Route path="/" exact element={<List list={list} add={add} remove={remove} />} />
        <Route path="/add" exact element={<Add />} />
      </Routes>
    </BrowserRouter>
  );
}

function Nav() {
  return (
    <div className='ul-box'>
      <ul className="menu-list list-box">
        <li className='왼쪽'><Link to="/">List</Link></li>
        <li><Link to="/add">Add New Movie</Link></li>
      </ul>
    </div>
  );
}

function List({ list, add, remove }) {
  const location = useLocation();
  let music = location.state;
  if (music != null) {
    add(music);
    location.state = null
  }

  return (
    <div className='box'>
      <h1>Movies</h1>
      <table className='table'>
        <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Genre</th>
            <th>Release Date</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {
            list.map((item) => {
              return (
                <tr key={item.id}>
                  <td>{item.id}</td>
                  <td>{item.title}</td>
                  <td>{item.genre}</td>
                  <td>{item.date}</td>
                  <td><button onClick={() => remove(item.id)}>delete</button></td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
    </div>
  );
}

function Add() {
  let [id, setid] = useState(0);
  let [title, setTitle] = useState("");
  let [genre, setGenre] = useState("");
  let [date, setdate] = useState("");
  const [error, setError] = useState("");

  const idChange = (e) => setid(e.target.value);
  const dateChange = (e) => setdate(e.target.value);
  const titleChange = (e) => setTitle(e.target.value);
  const genreChange = (e) => setGenre(e.target.value);
  const navigate = useNavigate();
  

  function addMovie() {
      if( id == ''){
        alert ('아이디를 입력해주세요.');
        return false;
      }
      if( title == ''){
        alert("제목을 입력하세요");
        return false;
      }
      if( genre == ''){
        alert("장르를 입력하세요")
        return false;
      }
      if( date == ''){
        alert("날짜를 입력하세요")
        return false;
      }
    navigate("/", {
      state: {
        title,
        date,
        genre,
        id
      }
    })
  }
  return (
    <div className='div'>
      <h1>Create Movie</h1>
      <div className="table">
        <div >
          <input type='text' onChange={idChange} placeholder='Input movie id' required />
        </div>
        <div>
          <input type='text' onChange={titleChange} placeholder='Input movie title' />
        </div>
        <div>
          <input type='text' onChange={genreChange} placeholder='Input movie genre' />
        </div>
        <div>
          <label>출시일 : </label>
          <input type='date' onChange={dateChange} />
        </div>
        <button onClick={addMovie}>Add Movie</button>
      </div>
    </div>
  );
}
export default App;