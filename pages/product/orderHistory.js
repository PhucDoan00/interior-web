import Layout from '../../components/layout'
import withAuth from '../../components/withAuth'
import OrderHistory from '../../components/product/OrderHistory'

const Cart = () => {
  return (
    <Layout>
      <OrderHistory />
    </Layout>
  )
}

export default withAuth(Cart)
