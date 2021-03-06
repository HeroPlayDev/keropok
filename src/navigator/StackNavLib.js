import * as React from 'react';
import { Image } from 'react-native';
import { createStackNavigator } from 'react-navigation-stack';
import { createAppContainer } from 'react-navigation';
import FullScrView from "../components/FullScrView/index"
import Libraryscreen from "../screens/Libraryscreen"
import Libraryscr from "../screens/Libraryscr"

import Utils from "../utils/index"
import Config from "../config/index"

const viewWidth = Config.Constant.SCREEN_WIDTH * (Utils.MethodUtils.isTablet() ? 0.65 : 0.85)


class Library extends React.Component {
    render() {
        return (
            <Libraryscreen props={this.props} />
        );
    }
}
class seaView extends React.Component {
    render() {
        return (
            <FullScrView.searchView props={this.props}/>
        );
    }
}


const LibStack = createStackNavigator(
    {
        Libraryscreen: Library,
        searchView: seaView,
    },
    { headerMode: 'none', },
    {
        initialRouteName: Library,
    },

);

const AppContainer = createAppContainer(LibStack);

export default class S extends React.Component {
    // static navigationOptions = {
    //     tabBarOptions: {
    //         tabBarVisible: false,
    //         borderTopColor: 'transparent',
    //         activeTintColor: Config.Constant.COLOR_BACKGROUND_AD,
    //         inactiveTintColor: Config.Constant.COLOR_INACTIVE_TINTCOLOR,
    //         labelStyle: {
    //             fontSize: Utils.MethodUtils.increaseSize(13),
    //         },
    //         tabStyle: {
    //             height: Utils.MethodUtils.increaseSize(50),
    //         },

    //     },
    //     tabBarIcon: ({ tintColor }) => (
    //         <Image style={{ tintColor: tintColor, height: Utils.MethodUtils.increaseSize(25), width: Utils.MethodUtils.increaseSize(25), }}
    //             source={require('../assets/images/home-Inactive.imageset/home-Inactive.png')} />
    //     ),
    //     borderTopColor: 'transparent',
    // };

    static navigationOptions = {
        tabBarOptions: {
            activeTintColor: Config.Constant.COLOR_BACKGROUND_AD,
            inactiveTintColor: Config.Constant.COLOR_INACTIVE_TINTCOLOR,
            labelStyle: {
                fontSize: Utils.MethodUtils.increaseSize(13),
            },
            tabStyle: {
                height: Utils.MethodUtils.increaseSize(50),
            },
        },
        tabBarIcon: ({ tintColor }) => (
            <Image style={{ tintColor: tintColor, height: 25, width: 31 }}
                source={require('../assets/images/audio-inactive.imageset/audio-inactive.png')} />
        )
    };

    render() {
        return <AppContainer />;
    }
}