import axios from 'axios'

export const getAllRooms = async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/v1/designidea')
    return response.data
  } catch (error) {
    console.log(error)
  }
}

export const getDesignStyleByRoom = async (id) => {
  try {
    const response = await axios.get(`http://localhost:8080/api/v1/designidea/${id}`)
    return response.data
  } catch (error) {
    console.log(error)
  }
}

export const getRoomsStyleById = async (id) => {
  try {
    const response = await axios.get(`http://localhost:8080/api/v1/designidea/${id}`)
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

export const getDesignStyleByRoom2 = async () => {
  try {
    const response = await axios.get(`http://localhost:8080/api/v1/designidea/5`)
    return response.data
  } catch (error) {
    console.log(error)
  }
}

export const getDesignId = async () => {
  const designLists = await getDesignStyleByRoom2()
  return designLists.thumbnailList.map((list) => ({
    params: {
      id: `${list.styleId}`,
    },
  }))
}

export const getDesignIdeaById = async (ideaId) => {
  try {
    const response = await axios.get(`http://localhost:8080/api/v1/idea/${ideaId}`)
    return response.data
  } catch (error) {
    console.log(error)
  }
}

// export const getRoomStyle = async () => {
//   const designLists = await getDesignStyleByRoom()
//   return designLists.thumbnailList.map((list) => ({
//     params: {
//       roomId:
//       id: `${list.styleId}`,
//     },
//   }))
// }

// export const getLvRoomIdeasById2 = async (styelid, id) => {
//   try {
//     const response = await axios.get(`http://localhost:8080/api/v1/designidea/${styelid}/${id}`)
//     return response.data
//   } catch (error) {
//     console.log(error)
//   }
// }

// export const getDesignIdeaById = async (ideaId) => {
//   try {
//     const response = await axios.get(`http://localhost:8080/api/v1/idea/${ideaId}`)
//     return response.data
//   } catch (error) {
//     console.log(error)
//   }
// }
