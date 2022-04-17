import axios from "axios";
import { URL_DEFAULT , URL } from './constant';


export const getListProduct = async () => {
  try {
     const response = await  axios.get(`${URL_DEFAULT}/products`)
    return response.data
  } catch (error) {
    console.log(error)
  }
}

export const getDetailProduct = async (id) => {
  try {
     const response = await  axios.get(`${URL_DEFAULT}/products/${id}`)
    return response.data
  } catch (error) {
    console.log(error)
  }
}

export const searchProduct = async ({search})=>{
  try {
    const response = await axios.get(`${URL_DEFAULT}/products/search`,
    
    )
    return response.data
  } catch (error) {
    console.log(error)
  }
}