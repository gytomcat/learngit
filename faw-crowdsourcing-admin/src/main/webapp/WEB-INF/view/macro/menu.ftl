<#-- 全局MENU -->
<#macro main name>
	<div class="frame-menu">
		<a id="toggleMenuBtn" class="frame-menu-console iconfont icon-3line-x" href="javascript:;"></a>
		<div class="frame-menu-wrapper">
			<dl class="frame-menu-item">
				<dt class="frame-menu-mod">
					<a href="javascript:;">
						<div class="menu-icon iconfont icon-caret"></div>
						<p class="menu-text">菜单</p>
					</a>
				</dt>
				<dd class="frame-menu-sub<#if name == "org"> frame-menu-active</#if>">
					<a href="${webServer}/company/list">
						<div class="menu-icon iconfont icon-shop"></div>
						<p class="menu-text">机构</p>
					</a>
				</dd>
				<dd class="frame-menu-sub<#if name == "idea"> frame-menu-active</#if>">
					<a href="${webServer}/idea/category/list">
						<div class="menu-icon iconfont icon-items"></div>
						<p class="menu-text">创意</p>
					</a>
				</dd>
				<dd class="frame-menu-sub<#if name == "project"> frame-menu-active</#if>">
					<a href="${webServer}/project/list">
						<div class="menu-icon iconfont icon-project"></div>
						<p class="menu-text">项目</p>
					</a>
				</dd>
				<dd class="frame-menu-sub<#if name == "system"> frame-menu-active</#if>">
					<a href="${webServer}/feedback/list">
						<div class="menu-icon iconfont icon-setting"></div>
						<p class="menu-text">系统</p>
					</a>
				</dd>
				<dd class="frame-menu-sub<#if name == "user"> frame-menu-active</#if>">
					<a href="${webServer}/member/list">
						<div class="menu-icon iconfont icon-members"></div>
						<p class="menu-text">用户</p>
					</a>
				</dd>
			</dl>
		</div>
	</div>
</#macro>

<#-- 子菜单:统计 -->
<#macro count name>
	<div class="frame-msub" id="frameMsub">
        <div class="frame-msub-hd">
			<h4 class="msub-title"><span class="iconfont icon-count"></span>统计管理</h4>
        </div>
        <div class="frame-msub-bd">
            <ul class="frame-msub-items">
            </ul>
        </div>
    </div>
</#macro>

<#-- 子菜单:机构 -->
<#macro org name>
	<div class="frame-msub" id="frameMsub">
        <div class="frame-msub-hd">
			<h4 class="msub-title"><span class="iconfont icon-shop"></span>机构管理</h4>
        </div>
        <div class="frame-msub-bd">
            <ul class="frame-msub-items">
                <li<#if name == "company"> class="msub-current"</#if>>
                    <a href="${webServer}/company/list"><span class="iconfont icon-list"></span>企业列表</a>
                </li>
            </ul>
        </div>
    </div>
</#macro>

<#-- 子菜单:创意 -->
<#macro idea name>
	<div class="frame-msub" id="frameMsub">
        <div class="frame-msub-hd">
			<h4 class="msub-title"><span class="iconfont icon-items"></span>创意管理</h4>
        </div>
        <div class="frame-msub-bd">
            <ul class="frame-msub-items">
                <li<#if name == "ideaCategory"> class="msub-current"</#if>>
                    <a href="${webServer}/idea/category/list"><span class="iconfont icon-category"></span>创意分类列表</a>
                </li>
                <li<#if name == "idea"> class="msub-current"</#if>>
                    <a href="${webServer}/idea/list"><span class="iconfont icon-list"></span>创意列表</a>
                </li>
            </ul>
        </div>
    </div>
</#macro>

<#-- 子菜单:活动 -->
<#macro activity name>
	<div class="frame-msub" id="frameMsub">
        <div class="frame-msub-hd">
			<h4 class="msub-title"><span class="iconfont icon-activity"></span>活动管理</h4>
        </div>
        <div class="frame-msub-bd">
            <ul class="frame-msub-items">
            </ul>
        </div>
    </div>
</#macro>

<#-- 子菜单:项目 -->
<#macro project name>
	<div class="frame-msub" id="frameMsub">
        <div class="frame-msub-hd">
			<h4 class="msub-title"><span class="iconfont icon-project"></span>项目管理</h4>
        </div>
        <div class="frame-msub-bd">
            <ul class="frame-msub-items">
                <li<#if name == "all"> class="msub-current"</#if>>
                    <a href="${webServer}/project/list?name=all"><span class="iconfont icon-list"></span>全部项目</a>
                </li>
                <li<#if name == "in_bidding"> class="msub-current"</#if>>
                    <a href="${webServer}/project/list?name=in_bidding&isOpen=Y"><span class="iconfont icon-list"></span>已发布项目</a>
                </li>
                <li<#if name == "bidded"> class="msub-current"</#if>>
                    <a href="${webServer}/project/list?name=bidded&hasBid=Y"><span class="iconfont icon-list"></span>已选标项目</a>
                </li>
                <li<#if name == "producting"> class="msub-current"</#if>>
                    <a href="${webServer}/project/list?name=producting&nowStatus=6"><span class="iconfont icon-list"></span>生产中项目</a>
                </li>
                <li<#if name == "accepting"> class="msub-current"</#if>>
                    <a href="${webServer}/project/list?name=accepting&nowStatus=7"><span class="iconfont icon-list"></span>待验收项目</a>
                </li>
                <li<#if name == "fineshed"> class="msub-current"</#if>>
                    <a href="${webServer}/project/list?name=fineshed&finished=Y"><span class="iconfont icon-list"></span>已完成项目</a>
                </li>
                <li<#if name == "timeout"> class="msub-current"</#if>>
                    <a href="${webServer}/project/list?name=timeout&nowStatus=-8"><span class="iconfont icon-list"></span>已过期项目</a>
                </li>
                <li<#if name == "isPatent"> class="msub-current"</#if>>
                    <a href="${webServer}/project/list?name=isPatent&isPatent=Y"><span class="iconfont icon-list"></span>专利项目</a>
                </li>
                <li<#if name == "thisMonth"> class="msub-current"</#if>>
                    <a href="${webServer}/project/list?name=thisMonth&thisMonth=Y"><span class="iconfont icon-list"></span>当月项目统计</a>
                </li>
                <li<#if name == "project"> class="msub-current"</#if>>
                    <a href="${webServer}/project/list"><span class="iconfont icon-list"></span>当前项目统计</a>
                </li>
                <li<#if name == "project"> class="msub-current"</#if>>
                    <a href="${webServer}/project/list"><span class="iconfont icon-list"></span>项目标签统计</a>
                </li>
            </ul>
        </div>
    </div>
</#macro>

<#-- 子菜单:系统 -->
<#macro system name>
	<div class="frame-msub" id="frameMsub">
        <div class="frame-msub-hd">
			<h4 class="msub-title"><span class="iconfont icon-setting"></span>系统管理</h4>
        </div>
        <div class="frame-msub-bd">
            <ul class="frame-msub-items">
                <li<#if name == "feedback"> class="msub-current"</#if>>
                    <a href="${webServer}/feedback/list"><span class="iconfont icon-list"></span>反馈列表</a>
                </li>
                <li<#if name == "message"> class="msub-current"</#if>>
                    <a href="${webServer}/message/list"><span class="iconfont icon-list"></span>消息列表</a>
                </li>
                <li<#if name == "news"> class="msub-current"</#if>>
                    <a href="${webServer}/news/list"><span class="iconfont icon-list"></span>新闻列表</a>
                </li>
                <li<#if name == "notice"> class="msub-current"</#if>>
                    <a href="${webServer}/notice/list"><span class="iconfont icon-list"></span>公告列表</a>
                </li>
                <li<#if name == "tag"> class="msub-current"</#if>>
                    <a href="${webServer}/tag/list"><span class="iconfont icon-list"></span>标签列表</a>
                </li>
            </ul>
        </div>
    </div>
</#macro>

<#-- 子菜单:用户 -->
<#macro user name>
	<div class="frame-msub" id="frameMsub">
        <div class="frame-msub-hd">
			<h4 class="msub-title"><span class="iconfont icon-members"></span>用户管理</h4>
        </div>
        <div class="frame-msub-bd">
            <ul class="frame-msub-items">
                <li<#if name == "member"> class="msub-current"</#if>>
                    <a href="${webServer}/member/list"><span class="iconfont icon-list"></span>会员列表</a>
                </li>
            </ul>
        </div>
    </div>
</#macro>

