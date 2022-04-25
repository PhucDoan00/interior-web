import axios from 'axios'
import { URL_DEFAULT, URL_PAYMENT } from './constant'

export const getListProduct = async () => {
  try {
    const response = await axios.get(`${URL_DEFAULT}/products`)
    return response.data
  } catch (error) {
    console.log(error)
  }
}

export const getDetailProduct = async (id) => {
  try {
    const response = await axios.get(`${URL_DEFAULT}/products/${id}`)
    return response.data
  } catch (error) {
    console.log(error)
  }
}

export const searchProduct = async ({ search }) => {
  try {
    const response = await axios.get(`${URL_DEFAULT}/products/search`, search)
    return response.data
  } catch (error) {
    console.log(error)
  }
}

export const searchById = async (id) => {
  try {
    const response = await axios.get(`${URL_DEFAULT}/products/category/${id}`)
    return response.data
  } catch (error) {
    console.log(error)
  }
}

export const searchBySelect = async (idColor) => {
  try {
    const response = await axios.get(`${URL_DEFAULT}/products`)
    return response.data
  } catch (error) {
    console.log(error)
  }
}

export const getPayment = async () => {
  try {
    const response = await axios.post(`${URL_PAYMENT}`)
    return response.data
  } catch (error) {
    console.log(error)
  }
}
