import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/board/mutations"
import actions from "@/store/board/actions"
import state from "@/store/board/states"

Vue.use(Vuex)

const BoardModule = {
    namespaced: true,// 네임 스페이스 - 구별이 가능하다 없을경우 구별 어려움
    state,
    actions,
    mutations,
}

export default BoardModule