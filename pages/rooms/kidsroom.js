import Footer from '../../components/footer'
import Layout from '../../components/layout'
import Topbar from '../../components/topbar'

export default function KidsRoom() {
  return (
    <div>
      <h1>{`This is Kid's room page`}</h1>
    </div>
  )
}

KidsRoom.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
      <Footer />
    </Layout>
  )
}
