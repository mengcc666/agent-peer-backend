# Fabric开发文档

​	Fabric提供了一个名为"fabric-samples"的区块链应用样例(仓库URL：https://github.com/hyperledger/fabric-samples)，这个样例包含一个可以快速部署的区块链网络、编写好的链码等等。这个样例还提供了一系列可执行的shell脚本，用命令行调用这些shell脚本就可以完成网络配置、启动区块链网络、创建通道、部署链码等操作。在完成这一系列的准备工作后，我们可以编写应用程序，通过Fabric SDK连接到区块链网络中节点的端口号，并调用智能合约完成业务功能。

​	代码分析以"fabric-samples" release-2.2来进行。

## 整体流程

​	在应用程序可以调用智能合约(链码)以执行业务操作之前，整体流程是这样的：

​		启动网络 -> 配置CA -> 创建通道 -> 部署链码

​	接下来一个个深入这些流程，梳理这些流程具体到代码的实现方法。

### 启动网络

​	启动网络的命令：$ ./network.sh up

​	以下是shell脚本关于解析"up"的代码片段。

```shell
if [ "${MODE}" == "up" ]; then
  networkUp
elif [ "${MODE}" == "createChannel" ]; then
  createChannel
elif [ "${MODE}" == "deployCC" ]; then
  deployCC
elif [ "${MODE}" == "down" ]; then
  networkDown
else
  printHelp
  exit 1
fi
```

​	可见，当