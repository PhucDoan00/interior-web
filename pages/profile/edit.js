import React from 'react'
import Link from 'next/link'
import { useRouter } from 'next/router'
import Footer from '../../components/footer'
import Layout from '../../components/layout'
import Topbar from '../../components/topbar'
import styles from '/styles/profile/edit.module.css'
import { useState, useEffect } from 'react'
import axios from 'axios'

export default function Edit() {
  const router = useRouter()
  const [user, setUser] = useState()
  const [info, setInfo] = useState()

  const [email, setEmail] = useState()
  const [name, setName] = useState()
  const [phone, setPhone] = useState()
  const [address, setAddress] = useState()

  const [oldpasword, setOlPassword] = useState()
  const [newPassword, setNewPassword] = useState()
  const [retypePass, setRetypePass] = useState()
  const [data, setData] = useState({
    emai: '',
    name: '',
    phone: '',
    address: '',
  })

  useEffect(() => {
    async function getUser() {
      const loggedInUser = localStorage.getItem('user')
      const takeInfo = JSON.parse(localStorage.getItem('user'))
      if (loggedInUser) {
        setUser(loggedInUser)
        setInfo(takeInfo)
      }
    }
    getUser()
  }, [])

  const handleChange = (e) => {
    const value = e.target.value
    setData({
      ...data,
      [e.target.name]: value,
    })
  }
  //Change Info
  // const handleUpdateInfo = async (e) => {
  //   e.preventDefault()
  //   const authenticationDetails = {
  //     email: email,
  //     name: name,
  //     phone: phone,
  //     address: address,
  //   }
  //   axios
  //     .post('http://localhost:8080/api/v1/profile/update', authenticationDetails)
  //     .then((response) => {
  //       console.log(response)
  //     })
  //     .catch((error) => {
  //       if (error.response) {
  //         console.log(error.response)
  //         console.log('server responded')
  //       } else if (error.request) {
  //         console.log('network error')
  //       } else {
  //         console.log(error)
  //       }
  //     })
  // }

  const updateInfo = async () => {
    const response = await fetch('http://localhost:8080/api/v1/profile/update', {
      method: 'POST',
      body: JSON.stringify({ email, name, phone, address }),
      headers: {
        'Content-Type': 'application/json',
      },
    })
    const data = await response.json()
    console.log(data)
  }

  //Change Pass
  const handleChangePass = () => {}

  return (
    <div className={styles.profileWrapper}>
      {user ? (
        <div className={styles.wrapper}>
          <div className={styles.profile}>
            <div className={styles.title}>
              <h1>Edit Profile</h1>
            </div>
            {/* Name */}
            <div className="row mt-4">
              <div className="col-3">
                <label htmlFor="name" className={`form-label my-3 ${styles.labelTitle}`}>
                  Full Name
                </label>
              </div>
              <div className="col">
                <input
                  type="email"
                  className="form-control my-3"
                  id="name"
                  // value={info.name}
                  // onChange={handleChange}
                  onChange={(e) => setName(e.target.value)}
                  placeholder={info.name}
                />
              </div>
            </div>
            {/* enail */}
            <div className="row">
              <div className="col-3">
                <label htmlFor="email" className={`form-label my-3 ${styles.labelTitle}`}>
                  Email
                </label>
              </div>
              <div className="col">
                <input
                  type="email"
                  className="form-control my-3"
                  id="email"
                  // value={info.email}
                  // onChange={handleChange}
                  onChange={(e) => setEmail(e.target.value)}
                  placeholder={info.email}
                />
              </div>
            </div>
            {/* Phone */}
            <div className="row">
              <div className="col-3">
                <label htmlFor="phone" className={`form-label my-3 ${styles.labelTitle}`}>
                  Phone Number
                </label>
              </div>
              <div className="col">
                <input
                  type="email"
                  className="form-control my-3"
                  id="phone"
                  // value={info.phone}
                  // onChange={handleChange}
                  onChange={(e) => setPhone(e.target.value)}
                  placeholder={info.phone}
                />
              </div>
            </div>
            {/* Address */}
            <div className="row">
              <div className="col-3">
                <label htmlFor="address" className={`form-label my-3 ${styles.labelTitle}`}>
                  Address
                </label>
              </div>
              <div className="col">
                <input
                  type="email"
                  className="form-control my-3"
                  id="address"
                  // value={info.address}
                  // onChange={handleChange}
                  onChange={(e) => setAddress(e.target.value)}
                  placeholder={info.address}
                />
              </div>
            </div>
            <div className={`row ${styles.rowBtn}`}>
              <div className="col-2 p-0 d-flex justify-content-center">
                <Link href="/profile/edit" passHref>
                  <div className={styles.btnEditt}>
                    <button className={`btn ${styles.btnCustom}`} onClick={updateInfo}>
                      Save
                    </button>
                  </div>
                </Link>
              </div>
              <div className="col-2 p-0 d-flex justify-content-center">
                <Link href="/profile/edit" passHref>
                  <div className={styles.btnEditt}>
                    <button className={`btn ${styles.btnCustom}`}>Cancel</button>
                  </div>
                </Link>
              </div>
            </div>
          </div>
          <div className={styles.passwordSection}>
            <div className={styles.titlee}>
              <h1> Change Password </h1>
            </div>
            <div className="row mt-4">
              <div className="col-3">
                <label htmlFor="oldpass" className={`form-label my-3 ${styles.labelTitle}`}>
                  Input old password
                </label>
              </div>
              <div className="col">
                <input
                  type="email"
                  className="form-control my-3"
                  id="oldpass"
                  // placeholder={info.name}
                />
              </div>
            </div>
            <div className="row">
              <div className="col-3">
                <label htmlFor="newpass" className={`form-label my-3 ${styles.labelTitle}`}>
                  Input new password
                </label>
              </div>
              <div className="col">
                <input
                  type="email"
                  className="form-control my-3"
                  id="newpass"
                  // placeholder={info.name}
                />
              </div>
              <div className="col-3">
                <label htmlFor="retypepass" className={`form-label my-3 ${styles.labelTitle}`}>
                  Re-type password
                </label>
              </div>
              <div className="col">
                <input
                  type="email"
                  className="form-control my-3"
                  id="retypepass"
                  // placeholder={info.name}
                />
              </div>
            </div>
            <div className={`row ${styles.rowBtn}`}>
              <div className="col-2 p-0 d-flex justify-content-center">
                <Link href="/profile/edit" passHref>
                  <div className={styles.btnEditt}>
                    <button className={`btn ${styles.btnCustom}`}>Save</button>
                  </div>
                </Link>
              </div>
              <div className="col-2 p-0 d-flex justify-content-center">
                <Link href="/profile/edit" passHref>
                  <div className={styles.btnEditt}>
                    <button className={`btn ${styles.btnCustom}`}>Cancel</button>
                  </div>
                </Link>
              </div>
            </div>
          </div>
        </div>
      ) : (
        <div style={{ marginTop: 90 + 'px' }}>
          <h1>Please Login to access this page</h1>
        </div>
      )}
    </div>
  )
}

Edit.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
      <Footer />
    </Layout>
  )
}
