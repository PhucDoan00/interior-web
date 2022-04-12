import axios from 'axios'

export const getDesignStyleLivingRoom = async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/v1/designidea/5')
    return response.data
  } catch (error) {
    console.log(error)
  }
}
