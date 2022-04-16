/* eslint-disable @next/next/no-img-element */
import { useState } from 'react/cjs/react.development';
import Layout from '../components/layout'
import Topbar from '../components/topbar'
import styles from '../styles/Login.module.css'
import axios from 'axios'
import { useRouter } from 'next/router';
// import { setUserSession } from './Utils/Common'

export default function LogIn() {
  const [email, setEmail] = useState();
  const [password, setPassword] = useState();
  const [error, setError] = useState(null);
  const router = useRouter();
  const handleSignin = () => {
    const authenticationDetails = {
      "email": email,
      "password": password,
    };
    axios.post('http://localhost:8080/api/auth/signin', authenticationDetails).then(function (result) {
      const response = result.data;
      // Storage.local.set(AUTH_TOKEN_KEY, response.accessToken);
      // Storage.local.set(AUTH_ACCESS_TOKEN_KEY, response.sessionToken);
      // Storage.local.set(AUTH_REFRESH_TOKEN_KEY, response.refreshToken);
      // if (rememberMe) {
      //   Storage.local.set('userpassword', password);
      //   Storage.local.set('username', username);
      // }
      // Storage.local.set('rememberMe', rememberMe);
      // dispatch({
      //   type: ACTION_TYPES.LOGIN_SUCCESS,
      //   response,
      // });
      // dispatch(getSession());
      router.push('/');
      console.log("success")
    })
      .catch(function (err) {
        console.log(err);
        setPassword('');
        // clearAuthToken();
        // if (err.message === !'' || JSON.stringify(err) !== '') {
        //   addErrorAlert('会員ID、もしくはパスワードが正しくありません。');
        // }
        // dispatch({
        //   type: ACTION_TYPES.LOGIN_FAIL,
        // });
        // return;
      });
  }

  return (
    <div className={`container ${styles.containerCustome}`}>
      <div className="row">
        <div className={`col ${styles.inputWrapper}`}>
          <div className="mb-3">
            <div className={styles.title}>
              <h2 className="d-flex justify-content-center">Welcome Back</h2>
              <p className="d-flex justify-content-center">
                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo
              </p>
            </div>
            <div className={styles.input}>
              <label htmlFor="exampleFormControlInput1" className="form-label d-flex my-3">
                Email address
              </label>
              <input
                type="email"
                className="form-control"
                id="exampleFormControlInput1"
                placeholder="name@example.com"
                onChange={e => setEmail(e.target.value)}
              />
            </div>
          </div>

          <div className={styles.input}>
            <label htmlFor="exampleFormControlInput1" className="form-label d-flex my-3">
              Password
            </label>
            <input
              type="password"
              className="form-control"
              id="exampleFormControlInput2"
              placeholder="****"
              onChange={e => setPassword(e.target.value)}
            />
          </div>
          <div className="d-flex justify-content-center">
            <button type="button" onClick={handleSignin} className={`btn ${styles.btnCustom} `}>
              Log in
            </button>
          </div>
        </div>
        <div className={`col d-flex justify-content-end ${styles.imgCol}`}>
          <img src="/login.png" className={`img-fluid ${styles.img}`} alt="Login Image" />
        </div>
      </div>
    </div>
  )
}

LogIn.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
    </Layout>
  )
}
