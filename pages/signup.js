/* eslint-disable @next/next/no-img-element */
import axios from 'axios';
import { useRouter } from 'next/router';
import { useState } from 'react';
import { confirmAlert } from 'react-confirm-alert';
import { NotificationContainer, NotificationManager } from 'react-notifications';
import 'react-notifications/lib/notifications.css';
import Layout from '../components/layout';
import Topbar from '../components/topbar';
import styles from '../styles/Signup.module.css';

export default function SignUp() {
  const [name, setName] = useState()
  const [email, setEmail] = useState()
  const [password, setPassword] = useState()
  const [address, setAddress] = useState()
  const [phone, setPhone] = useState()
  const router = useRouter()

  const handleSignUp = async () => {
    const signUpDetails = {
      name: name,
      email: email,
      password: password,
      address: address,
      phone: phone,
    }
    axios.post('http://localhost:8080/api/auth/signup', signUpDetails).then(function (result) {
      popupNoti();
    }).catch(function (error) {
      console.log(error);

    })
  }

  const popupNoti = async () => {
    NotificationManager.success('Login successfully', 'Succeed');
    await new Promise(resolve => setTimeout(resolve, 3000));
    router.push('/login')
  }

  function submit() {
    confirmAlert({
      title: 'Confirm',
      message: 'Are you sure to sign up?',
      buttons: [
        {
          label: 'Yes',
          onClick: () => handleSignUp()
        },
        {
          label: 'Cancel',
          onClick: () => { }
        }
      ]
    });
  }

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
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>
          <div className={styles.input}>
            <label htmlFor="exampleFormControlInput1" className="form-label d-flex my-3">
              Name
            </label>
            <input
              type="name"
              className="form-control"
              id="exampleFormControlInput1"
              placeholder="Enter your name"
              onChange={(e) => setName(e.target.value)}
              required
            />
          </div>
          <div className={styles.input}>
            <label htmlFor="exampleFormControlInput1" className="form-label d-flex my-3">
              Phone Number
            </label>
            <input
              type="phoneNumber"
              className="form-control"
              id="exampleFormControlInput1"
              placeholder="Enter your phone number"
              onChange={(e) => setPhone(e.target.value)}
              required
            />
          </div>
          <div className={styles.input}>
            <label htmlFor="exampleFormControlInput1" className="form-label d-flex my-3">
              Address
            </label>
            <input
              type="address"
              className="form-control"
              id="exampleFormControlInput1"
              placeholder="Enter your address"
              onChange={(e) => setAddress(e.target.value)}
              required
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
              onChange={(e) => setPassword(e.target.value)}
              required
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
              required
            //TODO
            />
          </div>
          <div className="d-flex justify-content-center">
            <button type="button" onClick={submit} className={`btn ${styles.btnCustom} `} >
              Sign Up
            </button>
          </div>
        </div>
        <div className="col">
          <div className={styles.img}>
            <img src="/login/signup.png" alt="Login Image" />
          </div>
        </div>
        <NotificationContainer />
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
