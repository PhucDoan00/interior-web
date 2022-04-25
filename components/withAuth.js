import { useRouter } from 'next/router'
import { confirmAlert } from 'react-confirm-alert'

const withAuth = (Component) => {
  const Auth = (props) => {
    const router = useRouter()
    const { isLoggedIn } = {}
    const pushLogin = () => {
      router.push('/login')
    }
    if (typeof window !== 'undefined') {
      // Login data added to local storage
      isLoggedIn = localStorage.getItem('user')
    }
    // If user is not logged in, return to login
    if (!isLoggedIn) {
      if (typeof window !== 'undefined') {
        confirmAlert({
          title: '',
          message: 'Please login to continue...',
          buttons: [
            {
              label: 'OK',
              onClick: () => pushLogin(),
            },
          ],
        })
      }
      return null
    }

    // If user is logged in, return original component
    return <Component {...props} />
  }

  return Auth
}

export default withAuth
