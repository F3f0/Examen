import { useState } from 'react';
import search from './api';
import logo from './price.jpg';
import './App.css';

const App = () => {
  const [productList, setProductList] = useState([]);
  const [name, setName] = useState('');

  const handelClick = () => {
    if (name.trim() === '') return;
    search(name).then((res) => {
      console.log(res);
      setProductList(res);
    });
  };

  return (
    <div className="App">
      <header className="App-header">
        <div className="App-intro">
          <img src={logo} className="App-logo" alt="logo" /> 
          <h2 className="pres">Search through today's opportunities</h2>
          <div className="addProduct">
            <input
              placeholder="Enter a product.."
              className="input"
              onChange={(e) => setName(e.target.value)}
            />
          </div>
          <div>
            {/* <button className="button" onClick={addProduct}> */}
            <button className="button" onClick={handelClick}>
              Search
            </button>
          </div>
          <div className="list">
            {productList.map((product) => (
              <div key={product.id}><div>{product.name} </div>
              <div className="price">{"Price "}{product.price}</div>
            </div>
            ))}
          </div>
        </div>
      </header>
    </div>
  );
};

export default App;
