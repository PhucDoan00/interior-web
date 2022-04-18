import axios from 'axios'
import { URL_DEFAULT, URL } from './constant'

export const getListProduct = async () => {
  try {
    const response = await axios.get(`${URL_DEFAULT}/products`)
    return response.data
  } catch (error) {
    console.log(error)
  }
}
