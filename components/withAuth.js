import { useRouter } from 'next/router'

const withAuth = Component => {

    const Auth = (props) => {
        const router = useRouter()
        const { isLoggedIn } = {};
        if (typeof window !== 'undefined') {
            // Login data added to local storage
            isLoggedIn = localStorage.getItem('user');
        }
        // If user is not logged in, return to login
        if (!isLoggedIn) {
            if (typeof window !== 'undefined') {
                router.push('/login')
            }
            return null
        }

        // If user is logged in, return original component
        return (
            <Component {...props} />
        );
    };

    return Auth;
};

export default withAuth;