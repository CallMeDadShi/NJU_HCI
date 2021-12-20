<template>

  <a-modal
      :visible="checkOrderModalVisible"
      title="查看详情"
      @cancel="cancelOrder"
  >
    <div>
      <a-descriptions  title="Custom Size" :size="size" :bordered="true">
        <a-descriptions-item label="userName">
          测试一号
        </a-descriptions-item>
        <a-descriptions-item label="hotelName">
          桂圆酒店
        </a-descriptions-item>
        <a-descriptions-item label="checkInDate">
          18:00:00
        </a-descriptions-item>
        <a-descriptions-item label="checkOutDate">
          18:00:00
        </a-descriptions-item>
        <a-descriptions-item label="Amount">
          $80.00
        </a-descriptions-item>
        <a-descriptions-item label="Discount">
          $0.00
        </a-descriptions-item>
        <a-descriptions-item label="Config Info">
          Data disk type: MongoDB
          <br />
          Database version: 3.4
          <br />
          Package: dds.mongo.mid
          <br />
          Storage space: 10 GB
          <br />
          Replication factor: 3
          <br />
          Region: East China 1<br />
        </a-descriptions-item>
      </a-descriptions>
      <br />
      <br />
      <a-descriptions title="Custom Size" :size="size">
        <a-descriptions-item label="Product">
          Cloud Database
        </a-descriptions-item>
        <a-descriptions-item label="Billing">
          Prepaid
        </a-descriptions-item>
        <a-descriptions-item label="Time">
          18:00:00
        </a-descriptions-item>
        <a-descriptions-item label="Amount">
          $80.00
        </a-descriptions-item>
        <a-descriptions-item label="Discount">
          $20.00
        </a-descriptions-item>
        <a-descriptions-item label="Official">
          $60.00
        </a-descriptions-item>
      </a-descriptions>
    </div>
  </a-modal>
</template>
<script>
import {mapGetters, mapMutations, mapActions} from 'vuex'

const moment = require('moment')

export default {
  name: 'checkOrderModal',
  data() {
    return {
      formItemLayout: {
        labelCol: {
          xs: {span: 12},
          sm: {span: 6},
        },
        wrapperCol: {
          xs: {span: 24},
          sm: {span: 16},
        },
      },
    }
  },
  computed: {
    ...mapGetters([
      'checkOrderModalVisible',
      'activeOrderId',
      'userId',
    ]),

  },
  beforeCreate() {
    this.form = this.$form.createForm(this, {name: 'checkOrderModal'});
  },
  methods: {
    ...mapMutations([
      'set_checkOrderParmas',
      'set_checkOrderModalVisible',

    ]),
    ...mapActions([
      'getUserOrders',

    ]),
    cancelOrder() {
      this.set_checkOrderModalVisible(false)
    },
    confirmOrder() {

    },

    handleSubmit(e) {
      e.preventDefault();
      this.form.validateFieldsAndScroll((err, values) => {
        if (!err) {
          const data = {
            checkInDate: moment(this.form.getFieldValue('date')[0]).format('YYYY-MM-DD'),
            checkOutDate: moment(this.form.getFieldValue('date')[1]).format('YYYY-MM-DD'),
            roomType: this.currentOrderRoom.roomType == '大床房' ? 'BigBed' : this.currentOrderRoom.roomType == '双床房' ? 'DoubleBed' : 'Family',
            roomNum: this.form.getFieldValue('roomNum'),
            peopleNum: this.form.getFieldValue('peopleNum'),
            haveChild: this.form.getFieldValue('haveChild'),
            price: this.form.getFieldValue('price'),
            clientName: this.form.getFieldValue('clientName'),
            phoneNumber: this.form.getFieldValue('clientName'),
            id: this.currentOrderId,
          }
          this.set_updateOrdersParams(data)
          const value = {record: this.updateOrdersParams, type: 'change'}
          this.updateOrders(value);

        }
      });
    },
  },
  watch: {
    totalPrice(val) {
      let data = {
        userId: this.userId,
        hotelId: this.currentHotelId,
        orderPrice: this.totalPrice,
        roomNum: this.form.getFieldValue('roomNum'),
        checkIn: moment(this.form.getFieldValue('date')[0]).format('YYYY-MM-DD'),
        checkOut: moment(this.form.getFieldValue('date')[1]).format('YYYY-MM-DD'),
      }
      this.getOrderMatchCoupons(data)
    }
  }
}
</script>