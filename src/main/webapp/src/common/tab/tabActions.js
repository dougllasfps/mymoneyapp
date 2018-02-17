export function selectTab(tabId){
    console.log(tabId);
    return{
        type : 'TAB_SELECTED',
        payload: tabId
    }
}

export function showTabs(... tabIds){
    const tabsToShow = {}    
    tabIds.forEach( tab => tabsToShow[tab] = true)
    return{
        type : 'TAB_SHOWED',
        payload: tabsToShow
    }
}