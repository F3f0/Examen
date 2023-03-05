import axios from 'axios';

const search = async (name) => {
  const { data } = await axios.post(
    'http://localhost:8081/items/contain',
    { name },
    {
      headers: {
        'Content-Type': 'application/json',
      },
    }
  );

  return data;
};

export default search;