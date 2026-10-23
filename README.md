<img width="1510" height="1280" alt="4b794181a4db11f3f3273d64d1123da3" src="https://github.com/user-attachments/assets/4d857ba7-9a50-4100-a7f2-1db8eaa1e7e7" />

# Create: Iron Grate

![Minecraft](https://img.shields.io/badge/Minecraft-1.20.1-green)
![Forge](https://img.shields.io/badge/Forge-47.4.1-orange)
![Create](https://img.shields.io/badge/Create-0.5.1%2B-blue)
![License](https://img.shields.io/badge/License-All%20Rights%20Reserved-lightgrey)

> 含熔岩的铁丝网铜箱 —— 为机械动力（Create）管道提供**无限熔岩**的装饰性方块。

---

## 简介

**Create: Iron Grate** 添加了一个方块：**含熔岩的铁丝网铜箱**（Lava-Filled Iron Grate Copper Box）。

铜制机壳包裹着铁丝网，网孔中透出缓缓流动的岩浆。它不只是一个好看的装饰品，更是一个**无限的熔岩流体源**，可直接接入机械动力的管道与流体系统，为你的熔炉阵列、流体储罐或生产链提供源源不断的热源。

## 特性

| 特性 | 说明 |
|------|------|
| 无限熔岩源 | 六个面均暴露 `IFluidHandler`，可被机械动力管道 / 泵持续抽取，永不耗尽 |
| 单向输出 | 只出不进，无法向其中注入任何流体 |
| 扳手拆卸 | 支持机械动力扳手，右键即可快捷拆卸 |
| 挖掘友好 | 镐 / 斧可加速挖掘；任何工具（包括空手）都能获得方块本体，无工具惩罚 |
| 坚固 | 硬度 3.5，抗爆性 6.0，铜质音效 |
| 动态岩浆 | 双层模型：外层透明铁丝网 + 内层原版岩浆动画，从任意角度都能看到流动的岩浆 |
| 双语 | 内置简体中文与英文 |

## 合成配方

在工作台中按下图摆放：

| 铜机壳 | 玻璃 | 铜机壳 |
|:--:|:--:|:--:|
| **铁丝网** | **熔岩桶** | **铁丝网** |
| 铜机壳 | 玻璃 | 铜机壳 |

材料说明：

- **铜机壳** = `create:copper_casing`
- **玻璃** = 任意 `#forge:glass`
- **铁丝网** = 装了夸克（Quark）时使用 `quark:grate`；未装时使用原版 `minecraft:iron_bars`（铁栏杆）
- **熔岩桶** = `minecraft:lava_bucket`（合成后自动返还空桶）

## 安装

1. 安装 **Minecraft Forge 47.4.1**（对应 Minecraft 1.20.1）
2. 安装 **机械动力 Create 0.5.1 或更高版本**
3. 下载 `create_irongrate-1.0.0.jar`（见 [Releases](../../releases) 页面）
4. 放入 `.minecraft/mods/` 目录
5. 启动游戏

## 依赖

| 模组 | 版本 | 必需 |
|------|------|------|
| Minecraft | 1.20.1 | ✅ 必需 |
| Forge | 47.4.x | ✅ 必需 |
| Create（机械动力） | 0.5.1+ | ✅ 必需 |
| Quark（夸克） | 4.0+ | ⭕ 可选，仅影响配方材料 |

## 从源码构建

```bash
git clone https://github.com/suicat01/create_irongrate.git cd create_irongrate
./gradlew build

构建产物位于 `build/libs/create_irongrate-1.0.0.jar`。

> 需要 JDK 17。Windows 下请使用 `gradlew.bat`。

## 许可证

All Rights Reserved.

## 作者

**suicat01**

---

## English

**Create: Iron Grate** adds the **Lava-Filled Iron Grate Copper Box** — a copper-cased iron grate with animated lava glowing through its mesh.

It works as an **infinite lava fluid source**: all six faces expose an `IFluidHandler`, so Create pipes and pumps can drain it forever, while injection is rejected.

**Crafting** (shaped, 3×3):

| Copper Casing | Glass | Copper Casing |
|:---:|:---:|:---:|
| **Iron Grate** | **Lava Bucket** | **Iron Grate** |
| Copper Casing | Glass | Copper Casing |

- *Iron Grate* = `quark:grate` when Quark is installed, otherwise `minecraft:iron_bars`
- *Glass* = any `#forge:glass`
- The lava bucket is returned empty

**Requirements:** Minecraft 1.20.1 · Forge 47.4.1 · Create 0.5.1+

**Build:** `./gradlew build` → `build/libs/create_irongrate-1.0.0.jar`

Licensed under All Rights Reserved. Author: **suicat01**.
