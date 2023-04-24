CREATE TABLE `chaincode`  (
  `chaincodeName` varchar(255) NULL,
  `uploadUser` varchar(255) NULL,
  `path` varchar(255) NULL,
  `language` varchar(255) NULL
);

CREATE TABLE `user`  (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `registerDate` datetime NULL,
  `lastLoginDate` datetime NULL
);

CREATE TABLE `userLog`  (
  `username` varchar(255) NULL,
  `desc` varchar(255) NULL,
  `time` datetime NULL
);

