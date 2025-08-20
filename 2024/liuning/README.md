# 基于虚幻引擎5的2.5D游戏demo

全部的项目文件还是太大了💦💦

通过网盘分享的文件：Windows (5).zip
链接: https://pan.baidu.com/s/1HxyT2b8vt1RkzgXLyMwhXw?pwd=5itz 提取码: 5itz

未经引擎优化的版本，对CPU/GPU的占用情况不堪忍睹，基本上拉满💦。

## 简介
基于虚幻引擎5.2版本的游戏demo
## 内容
### 2.5D
- 游戏角色为2D，其他物品，场景为3D.
### 语言
- UE5增强输入
- 蓝图含量100%（作为初学者的过渡阶段）
### UI
- 主菜单（包含游戏指南/开始游戏/退出游戏）的悬停和音乐效果
- 游戏指南（How to play)中未包含的按键或鼠标在游戏里均有文本提示
- 用于玩家属性的 UI 元素（HUD）
- 游戏过程中的交互提示词以及对话系统
- 地图
- 音量控制

<div align="center">
    <img src="https://github.com/Aisssky/2025-summer/blob/c71b7a281e21cb640f072850c9b4d4a6fffda105/2024/liuning/gifs/menu1.gif" alt="Widget" width="500">
</div>

<div align="center">
    <img src="https://github.com/Aisssky/2025-summer/blob/c71b7a281e21cb640f072850c9b4d4a6fffda105/2024/liuning/gifs/Z6D.gif" alt="Widget" width="500">
</div>
### 背包系统
<div align="center">
    <img src="https://github.com/Aisssky/2025-summer/blob/c71b7a281e21cb640f072850c9b4d4a6fffda105/2024/liuning/gifs/Inventory1.gif" alt="Inventory System" width="500">
</div>

### 农作系统
- 种植农作物以及农作物生长倒计时

<div align="center">
    <img src="https://github.com/Aisssky/2025-summer/blob/c71b7a281e21cb640f072850c9b4d4a6fffda105/2024/liuning/gifs/FarmA6.gif" alt="Farm System" width="500">
</div>

- 然而存在只能种不能收的bug（我称之为游戏机制
### 对话系统
- 可以派发任务的可回复的NPC对话(具有行为树的对话AI）
- 可指引玩家行动的不可回复的NPC对话

<div align="center">
    <img src="https://github.com/Aisssky/2025-summer/blob/c71b7a281e21cb640f072850c9b4d4a6fffda105/2024/liuning/gifs/dialog34.gif" alt="Dialog System" width="500">
</div>

### 地图
- 主地图
- 家

<div align="center">
    <img src="https://github.com/Aisssky/2025-summer/blob/c71b7a281e21cb640f072850c9b4d4a6fffda105/2024/liuning/gifs/Home4D.gif" alt="Home Map" width="500">
</div>

- 夜里的村庄(未启用)

<div align="center">
     <img width="500" height="651" alt="79244fb88645aaf012b3a502d0bb855c" src="https://github.com/user-attachments/assets/919c690f-f6a9-46f7-8768-539cca30e44f" />
</div>
- 为了预测玩家行为的空气墙

<div align="center">
    <img src="https://github.com/Aisssky/2025-summer/blob/c71b7a281e21cb640f072850c9b4d4a6fffda105/2024/liuning/gifs/wall72.gif" alt="Home Map" width="500">
</div>

### 目前无法定位的问题
- 背包系统在引擎内运行正常然而在打包出来的exe中无法正确运行的问题。
