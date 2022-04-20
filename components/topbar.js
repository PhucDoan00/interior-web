/* eslint-disable @next/next/no-img-element */
/* eslint-disable @next/next/link-passhref */
import Link from 'next/link'
import { useState } from 'react'
import { useEffect } from 'react'
import styles from './topbar.module.css'

export default function Topbar() {
  const [user, setUser] = useState()
  const [navbar, setNavBar] = useState(false)

  useEffect(() => {
    const loggedInUser = localStorage.getItem('user')
    if (loggedInUser) {
      setUser(loggedInUser)
    }
  }, [])

  const handleSignOut = () => {
    setUser('')
    localStorage.setItem('user', '')
  }
  useEffect(() => {
    const opacityNavBar = () => {
      if (window.scrollY >= 80) {
        setNavBar(true)
      } else {
        setNavBar(false)
      }
    }
    window.addEventListener('scroll', opacityNavBar)
  }, [])

  return (
    <nav className={navbar ? styles.navactive : styles.nav}>
      <div className="container d-flex justify-content-between align-items-center ">
        <div className={`d-flex justify-content-between align-items-center ${styles.topbar}`}>
          <Link href="/">
            <img src="/logo/logo.png" alt="logo" style={{ height: 70 + 'px', width: 110 + 'px' }} />
          </Link>
          <Link href="/stylequiz">
            <a>Style Quiz</a>
          </Link>
          <Link href="/rooms">
            <a>Design Ideas</a>
          </Link>
          <Link href="/shop">
            <a>Shop</a>
          </Link>
        </div>
        <div>
          {user ? (
            <div className="button">
              <Link href="/">
                <button
                  type="button"
                  onClick={handleSignOut}
                  className={`btn mx-2 btn-outline ${styles.btnCustomOutlinePrimary}`}
                >
                  Sign out
                </button>
              </Link>
            </div>
          ) : (
            <div className="button">
              <Link href="/signup">
                <button
                  type="button"
                  className={`btn mx-2 btn-outline ${styles.btnCustomOutlinePrimary}`}
                >
                  Sign up
                </button>
              </Link>
              <Link href="/login">
                <button type="button" className={`btn  ${styles.btnCustomPrimary}`}>
                  Log in
                </button>
              </Link>
            </div>
          )}
        </div>
      </div>
    </nav>
  )
}
