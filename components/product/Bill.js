import styles from '../../styles/Product.module.css'

const Bill = () => {
  return (
    <div className={`${styles.mt_400}`}>
      <div className={`container ${styles.all}`}>
        <div className="row">
          <div className={`${styles['create-title']} ${styles['manage-title']} mt-3`}>
            Update Product
          </div>
        </div>
        <div className="row">
          <div className="col-12">
                      <div className={`${styles['search-form']}`}>
              <input
                type="text"
                placeholder="Search field"
                className={`${styles['input-color']}`}
              />
              <button className={`${styles.search}`}>Search</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}
export default Bill
