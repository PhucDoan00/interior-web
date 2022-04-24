import Layout from '../components/layout'
import Topbar from '../components/topbar'
import Footer from '../components/footer'
import Image from 'next/image'
import styles from '../styles/Home.module.css'
import React, { useState, useEffect } from 'react'
import ShopCustomer from '../components/shop/ShopCustomer'

export default function Shop() {
  useEffect(() => {
    // fetch api here
    //
  }, [])

  return (
    <Layout>
      <Topbar />
      <ShopCustomer />
      <Footer />
    </Layout>
  )
}
