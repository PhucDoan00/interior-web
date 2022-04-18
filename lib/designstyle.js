import axios from 'axios'

export const getAllRooms = async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/v1/designidea')
    return response.data
  } catch (error) {
    console.log(error)
  }
}
export const getRoomId = async () => {
  const roomIds = await getAllRooms()
  return roomIds.map((roomId) => ({
    params: {
      roomId: `${roomId.categoryId}`,
    },
  }))
}
export const getRoomsStyleById = async (id) => {
  try {
    const response = await axios.get(`http://localhost:8080/api/v1/designidea/${id}`)
    return response.data
  } catch (error) {
    console.log(error)
  }
}

export const getIdeasByStyleId = async (catId, id) => {
  try {
    const response = await axios.get(`http://localhost:8080/api/v1/designidea/${catId}/${id}`)
    return response.data
  } catch (error) {
    console.log(error)
  }
}

// export const getLvRoom = async () => {
//   // const styleId = Cookies.get('categoryId')

//   // const styleId = localStorage.getItem('categoryId')
//   try {
//     const response = await axios.get(`http://localhost:8080/api/v1/designidea/5`)
//     // console.log('>>>>', response.data)
//     return response.data
//   } catch (error) {
//     console.log(error)
//   }
// }

// export const getDesignId = async () => {
//   const roomLists = await getLvRoom()
//   return roomLists.thumbnailList.map((roomlist) => ({
//     params: {
//       id: `${roomlist.styleId}`,
//     },
//   }))
// }
