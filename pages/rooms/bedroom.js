import Footer from '../../components/footer'
import Layout from '../../components/layout'
import Topbar from '../../components/topbar'

export default function BedRoom() {
  return (
    <div>
      <h1>This is Bed room page</h1>
    </div>
  )
}

BedRoom.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
      <Footer />
    </Layout>
  )
}
