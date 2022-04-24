import React from 'react'
import Link from 'next/link'
import Layout from '../../components/layout'
import Topbar from '../../components/topbar'
import Footer from '../../components/footer'
import styles from '/styles/profile/profile.module.css'
import { useState, useEffect } from 'react'

export default function Profile() {
  const [user, setUser] = useState()
  const [info, setInfo] = useState()

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

  return (
    <div className={styles.profileWrapper}>
      {user ? (
        <div className={styles.profile}>
          <div className={styles.title}>
            <h1>Profile Detail</h1>
          </div>
          {/* Name */}
          <div className="row mt-4">
            <div className="col-3">
              <label
                htmlFor="exampleFormControlInput1"
                className={`form-label my-3 ${styles.labelTitle}`}
              >
                Full Name
              </label>
            </div>
            <div className="col">
              <input
                type="email"
                className="form-control my-3"
                id="exampleFormControlInput1"
                placeholder={info.name}
                disabled
              />
            </div>
          </div>
          {/* Emal */}
          <div className="row">
            <div className="col-3">
              <label
                htmlFor="exampleFormControlInput1"
                className={`form-label my-3 ${styles.labelTitle}`}
              >
                Email address
              </label>
            </div>
            <div className="col">
              <input
                type="email"
                className="form-control my-3"
                id="exampleFormControlInput1"
                placeholder={info.email}
                disabled
              />
            </div>
          </div>
          {/* Phone */}
          <div className="row">
            <div className="col-3">
              <label
                htmlFor="exampleFormControlInput1"
                className={`form-label my-3 ${styles.labelTitle}`}
              >
                Phone Number
              </label>
            </div>
            <div className="col">
              <input
                type="email"
                className="form-control my-3"
                id="exampleFormControlInput1"
                placeholder={info.phone}
                disabled
              />
            </div>
          </div>
          {/* Address */}
          <div className="row">
            <div className="col-3">
              <label
                htmlFor="exampleFormControlInput1"
                className={`form-label my-3 ${styles.labelTitle}`}
              >
                Address
              </label>
            </div>
            <div className="col">
              <input
                type="email"
                className="form-control my-3"
                id="exampleFormControlInput1"
                placeholder={info.address}
                disabled
              />
            </div>
          </div>
          <Link href="/profile/edit" passHref>
            <div className={styles.btnEdit}>
              <button className={`btn ${styles.btnCustom}`}>Edit</button>
            </div>
          </Link>
        </div>
      ) : (
        <div>
          <h1>Please Login to access this page</h1>
        </div>
      )}
    </div>
  )
}

Profile.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
      <Footer />
    </Layout>
  )
}
