import axios from 'axios'
import { URL_DEFAULT_ROOM } from './constant'

//1
//Call Api get 6 rooms
export const getAllRooms = async () => {
  try {
    const response = await axios.get(`${URL_DEFAULT_ROOM}`)
    return response.data
  } catch (error) {
    console.log(error)
  }
}
//2
//Call Api get id of each room
export const getRoomId = async () => {
  const roomIds = await getAllRooms()
  return roomIds.map((roomId) => ({
    params: {
      roomId: `${roomId.categoryId}`,
    },
  }))
}
//Call Api to get data depend on id above
export const getRoomsStyleById = async (id) => {
  try {
    const response = await axios.get(`${URL_DEFAULT_ROOM}/${id}`)
    return response.data
  } catch (error) {
    console.log(error)
  }
}

//3
//Call Api to get data idea of each style depend on room id and style id
export const getIdeasByStyleId = async (catId, id) => {
  try {
    const response = await axios.get(`${URL_DEFAULT_ROOM}/${catId}/${id}`)
    return response.data
  } catch (error) {
    console.log(error)
  }
}

//4
//Call api to get data detail of each idea
export const getDetailIdeaById = async (id) => {
  try {
    const response = await axios.get(`${URL_DEFAULT_ROOM}/idea/${id}`)
    return response.data
  } catch (error) {
    console.log(error)
  }
}
