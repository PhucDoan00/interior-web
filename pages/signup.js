/* eslint-disable @next/next/no-img-element */
import Layout from '../components/layout'
import Topbar from '../components/topbar'
import styles from '../styles/Signup.module.css'

export default function SignUp() {
  return (
    <div className={`container ${styles.containerCustome}`}>
      <div className="row">
        <div className={`col ${styles.inputWrapper}`}>
          <div className={styles.title}>
            <h2 className="d-flex justify-content-center">Welcome To Sprakles</h2>
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
          <div className={styles.input}>
            <label htmlFor="exampleFormControlInput1" className="form-label d-flex my-3">
              Phone Number
            </label>
            <input
              type="email"
              className="form-control"
              id="exampleFormControlInput1"
              placeholder="Enter your phone number"
            />
          </div>
          <div className={styles.input}>
            <label htmlFor="exampleFormControlInput1" className="form-label d-flex my-3">
              Address
            </label>
            <input
              type="email"
              className="form-control"
              id="exampleFormControlInput1"
              placeholder="Enter your address"
            />
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
          <div className={styles.input}>
            <label htmlFor="exampleFormControlInput1" className="form-label d-flex my-3">
              Confirm Password
            </label>
            <input
              type="password"
              className="form-control"
              id="exampleFormControlInput2"
              placeholder="Confirm your password"
            />
          </div>
          <div className="d-flex justify-content-center">
            <button type="button" className={`btn ${styles.btnCustom} `}>
              Sign Up
            </button>
          </div>
        </div>
        <div className="col">
          <div className={styles.img}>
            <img src="/login/signup.png" alt="Login Image" />
          </div>
        </div>
      </div>
    </div>
  )
}

SignUp.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
    </Layout>
  )
}
