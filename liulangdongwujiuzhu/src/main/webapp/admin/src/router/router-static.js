import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import fenxiang from '@/views/modules/fenxiang/list'
    import huifang from '@/views/modules/huifang/list'
    import liulangdongwu from '@/views/modules/liulangdongwu/list'
    import liulangdongwuCollection from '@/views/modules/liulangdongwuCollection/list'
    import liulangdongwuLiuyan from '@/views/modules/liulangdongwuLiuyan/list'
    import liulangdongwuOrder from '@/views/modules/liulangdongwuOrder/list'
    import yezhu from '@/views/modules/yezhu/list'
    import zhiyuanzhe from '@/views/modules/zhiyuanzhe/list'
    import config from '@/views/modules/config/list'
    import dictionaryFenxiang from '@/views/modules/dictionaryFenxiang/list'
    import dictionaryHuifang from '@/views/modules/dictionaryHuifang/list'
    import dictionaryJiankang from '@/views/modules/dictionaryJiankang/list'
    import dictionaryJiuzhu from '@/views/modules/dictionaryJiuzhu/list'
    import dictionaryJueyu from '@/views/modules/dictionaryJueyu/list'
    import dictionaryLingyang from '@/views/modules/dictionaryLingyang/list'
    import dictionaryLiulangdongwu from '@/views/modules/dictionaryLiulangdongwu/list'
    import dictionaryLiulangdongwuCollection from '@/views/modules/dictionaryLiulangdongwuCollection/list'
    import dictionaryLiulangdongwuOrderYesno from '@/views/modules/dictionaryLiulangdongwuOrderYesno/list'
    import dictionaryLiulangdongwuPinzhong from '@/views/modules/dictionaryLiulangdongwuPinzhong/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryYimiao from '@/views/modules/dictionaryYimiao/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryFenxiang',
        name: '分享类型',
        component: dictionaryFenxiang
    }
    ,{
        path: '/dictionaryHuifang',
        name: '回访类型',
        component: dictionaryHuifang
    }
    ,{
        path: '/dictionaryJiankang',
        name: '是否健康',
        component: dictionaryJiankang
    }
    ,{
        path: '/dictionaryJiuzhu',
        name: '是否救助',
        component: dictionaryJiuzhu
    }
    ,{
        path: '/dictionaryJueyu',
        name: '是否绝育',
        component: dictionaryJueyu
    }
    ,{
        path: '/dictionaryLingyang',
        name: '是否领养',
        component: dictionaryLingyang
    }
    ,{
        path: '/dictionaryLiulangdongwu',
        name: '流浪动物类型',
        component: dictionaryLiulangdongwu
    }
    ,{
        path: '/dictionaryLiulangdongwuCollection',
        name: '收藏表类型',
        component: dictionaryLiulangdongwuCollection
    }
    ,{
        path: '/dictionaryLiulangdongwuOrderYesno',
        name: '申请状态',
        component: dictionaryLiulangdongwuOrderYesno
    }
    ,{
        path: '/dictionaryLiulangdongwuPinzhong',
        name: '动物品种',
        component: dictionaryLiulangdongwuPinzhong
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryYimiao',
        name: '是否打疫苗',
        component: dictionaryYimiao
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/fenxiang',
        name: '宠物分享',
        component: fenxiang
      }
    ,{
        path: '/huifang',
        name: '回访',
        component: huifang
      }
    ,{
        path: '/liulangdongwu',
        name: '流浪动物',
        component: liulangdongwu
      }
    ,{
        path: '/liulangdongwuCollection',
        name: '流浪动物收藏',
        component: liulangdongwuCollection
      }
    ,{
        path: '/liulangdongwuLiuyan',
        name: '流浪动物留言',
        component: liulangdongwuLiuyan
      }
    ,{
        path: '/liulangdongwuOrder',
        name: '流浪动物领养申请',
        component: liulangdongwuOrder
      }
    ,{
        path: '/yezhu',
        name: '业主',
        component: yezhu
      }
    ,{
        path: '/zhiyuanzhe',
        name: '志愿者',
        component: zhiyuanzhe
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
