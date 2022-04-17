import styles from '../../styles/Home.module.css'
import { Icon } from '@iconify/react'

const ProductCart = () => {
  return (
    <div className={`${styles.mt_100}`}>
      <div className="container">
        <div className="row d-flex">
          <h5
            className="d-flex justify-content-center"
            style={{ fontWeight: 'lighter', display: 'inline-block' }}
          >
            Your Shopping Cart
          </h5>
        </div>
        <div className="remove">
          <Icon icon="clarity:remove-line" style={{ float: 'right' }} />
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
                <tr>
                  <th scope="row">
                    <div className="item d-flex">
                      <img
                        src="/1.png"
                        width="50px"
                        height="50px"
                        alt=""
                        style={{ objectFit: 'cover' }}
                      />
                      <div className="title_check m-2">
                        <h6 style={{ fontWeight: 'bold', fontSize: '12px' }}>
                          Office Elegant Nero Noce Leather Chair
                        </h6>
                        <p style={{ fontWeight: 'lighter', fontSize: '10px' }}>
                          Size 25.6 x 38.98 inches
                        </p>
                      </div>
                    </div>
                  </th>
                  <td className={styles.light}>
                    <select className={`${styles.choose_select}`} value={1}>
                      <option selected>1</option>
                      <option value="2">2</option>
                      <option value="3">3</option>
                    </select>
                    <a href="" style={{ display: 'block', color: 'red', margin: '0 10px' }}>
                      Delete
                    </a>
                  </td>
                  <td className={styles.light}>500</td>
                </tr>
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
                      400
                      <br />
                      500
                    </h5>
                  </td>
                </tr>
                <tr>
                  <td>
                    <h6 style={{ fontWeight: 'bold', fontSize: '15px' }}>Estimated Total</h6>
                  </td>
                  <td></td>
                  <td>500</td>
                </tr>
              </tbody>
            </table>
          </div>
          <div
            className="col-sm-4"
            style={{
              border: '1px solid rgb(189, 185, 185)',
              padding: '20px',
              borderRadius: '5px',
              marginRight: '10px',
            }}
          >
            <h5 style={{ fontWeight: 'lighter', display: 'inline-block', textAlign: 'center' }}>
              Shipping Address
            </h5>
            <div className="info mt-4">
              <div className={`${styles.text_align_left}`}>
                <span className={`${styles.f15} `}>Name</span>{' '}
                <span className={`${styles.f15} ${styles.fontW_500} ${styles.m}`}>
                  CustomerName
                </span>
              </div>
              <div className={`${styles.text_align_left}`}>
                <span className={`${styles.f15} `}>Phone Number</span>{' '}
                <span className={`${styles.f15} ${styles.fontW_500} ${styles.m}`}>
                  (123)-456-789
                </span>
              </div>
              <div className={`${styles.text_align_left}`}>
                <span className={`${styles.f15} ${styles.text_align_left}`}>Gmail</span>{' '}
                <span className={`${styles.f15} ${styles.fontW_500} ${styles.m}`}>
                  John@gmail.com
                </span>
              </div>
              <div className="i">
                <span className={`${styles.f15} ${styles.text_align_left}`}>Address</span>{' '}
                <span className={`${styles.f15} ${styles.fontW_500} ${styles.m}`}>
                  6391 Delaware 10299
                </span>
              </div>
            </div>

            <div className="shipping_address">
              <h5
                style={{
                  fontWeight: 'lighter',
                  display: 'inline-block',
                  textAlign: 'center',
                  marginTop: '40px',
                }}
              >
                Shipping Address
              </h5>
              <div style={{ textAlign: 'center', marginTop: '10px' }}>
                <button className={`${styles.button} ${styles.bg_yellow}`}>Checkout</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}
export default ProductCart
