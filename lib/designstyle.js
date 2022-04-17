import axios from 'axios'

export const getDesignStyleByRoom = async (id) => {
  try {
    const response = await axios.get(`http://localhost:8080/api/v1/designidea/${id}`)
    return response.data
  } catch (error) {
    console.log(error)
  }
}

export const getDesignIdeaById = async (ideaId) => {
  try {
    const response = await axios.get(`http://localhost:8080/api/v1/idea/${ideaId}`)
    return response.data
  } catch (error) {
    console.log(error)
  }
}