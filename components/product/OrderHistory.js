import styles from '../../styles/Home.module.css'
import { Icon } from '@iconify/react'
import { useRouter } from 'next/router'
import { useEffect, useState } from 'react'

const OrderHistory = () => {
  const [cart, setCart] = useState([])
  const [total, setTotal] = useState('')
  const [shipping, setShipping] = useState('')
  const [isRender, setIsRender] = useState(false)
  const router = useRouter()

  useEffect(() => {
    let data = JSON.parse(localStorage.getItem('cart'))
    let totals = 0
    if (data) {
      data.map((e) => {
        totals += Number(e.product.price) * Number(e.product.quantity)
      })
      setShipping(totals / 100)
      setTotal(totals)
      setCart(data)
    }
  }, [isRender])

  // const handleRemoveItem = (item) => {
  //   let data = JSON.parse(localStorage.getItem('cart'))
  //   let datas = data.filter((person) => person.product.productId != item)
  //   // remove localstorage
  //   localStorage.removeItem('cart')
  //   localStorage.setItem('cart', JSON.stringify(datas))
  //   setCart(datas)
  //   setIsRender(true)
  // }

  const handleRedirectPage = () => {
    router.push('/shop')
  }

  // const handleCheckOut = () => {
  //   router.push('/success')
  // }

  return (
    <div className={`${styles.mt_100}`}>
      <div className="container">
        <div className="row d-flex">
          <h5
            className="d-flex justify-content-center"
            style={{ fontWeight: 'bold', display: 'inline-block' }}
          >
            Order History
          </h5>
        </div>
        <div className="remove">
          <Icon
            icon="clarity:remove-line"
            style={{ float: 'right' }}
            onClick={handleRedirectPage}
          />
        </div>
        <div className="row pt-4 d-flex " style={{ justifyContent: 'space-around' }}>
          <div
            className={`col-sm-7`}
            style={{ border: '1px solid rgb(189, 185, 185)', padding: '20px', borderRadius: '5px' }}
          >
            <h5 style={{ fontWeight: 'lighter', display: 'inline-block' }}>Your Order</h5>
            <table className="table">
              <thead>
                <tr>
                  <th scope="col">Item</th>
                  <th scope="col">Quantity</th>
                  <th scope="col">Price</th>
                </tr>
              </thead>
              <tbody>
                {cart?.map((e) => (
                  <tr key={e.product.productId}>
                    <th scope="row">
                      <div className="item d-flex">
                        <img
                          src={e.product.image}
                          width="50px"
                          height="50px"
                          alt=""
                          style={{ objectFit: 'cover' }}
                        />
                        <div className="title_check m-2">
                          <h6 style={{ fontWeight: 'bold', fontSize: '12px' }}>
                            {e.product.productName}
                          </h6>
                          <p style={{ fontWeight: 'lighter', fontSize: '10px' }}>
                            {e.product.dimension}
                          </p>
                        </div>
                      </div>
                    </th>
                    <td className={styles.light}>
                      <label
                        style={{
                          marginLeft: '10px',
                        }}
                      >
                        {e.select}
                      </label>
                    </td>
                    <td className={styles.light}>{e.product.price}</td>
                  </tr>
                ))}
                <tr>
                  <td>
                    <h5 style={{ fontWeight: 'lighter', fontSize: '15px' }}>
                      Subtotal
                      <br />
                      Estimate Shipping
                    </h5>
                  </td>
                  <td></td>
                  <td>
                    <h5 style={{ fontWeight: 'lighter', fontSize: '15px' }}>
                      {total}
                      <br />
                      {shipping}
                    </h5>
                  </td>
                </tr>
                <tr>
                  <td>
                    <h6 style={{ fontWeight: 'bold', fontSize: '15px' }}>Estimated Total</h6>
                  </td>
                  <td></td>
                  <td>{total + shipping}</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  )
}

export default OrderHistory
