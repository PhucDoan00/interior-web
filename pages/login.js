/* eslint-disable @next/next/no-img-element */
import Layout from '../components/layout'
import Topbar from '../components/topbar'
import styles from '../styles/Login.module.css'

export default function LogIn() {
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
            />
          </div>
          <div className="d-flex justify-content-center">
            <button type="button" className={`btn ${styles.btnCustom} `}>
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
