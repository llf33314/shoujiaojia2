import axios from 'axios'
import Promise from 'promise'
import router from './../router/index'
const Axios = axios.create({
  timeout: 10000,
});

export default Axios
