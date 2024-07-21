-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 21, 2024 at 09:25 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quiz_trivia`
--

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `category` varchar(255) DEFAULT NULL,
  `correct_answer` varchar(255) DEFAULT NULL,
  `difficulty` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  `question` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`category`, `correct_answer`, `difficulty`, `id`, `question`, `type`) VALUES
('Entertainment: Video Games', 'true', 'easy', '034006e9-5c98-403b-9d4c-15a0361b2c02', 'The Indie Game Development Studio Cing, developers of Hotel Dusk and Last Window, went bankrupt on March 1st, 2010.', 'boolean'),
('Entertainment: Board Games', 'false', 'easy', '0b574275-98a6-4fae-990f-d7bb0d5b5bc6', 'The Angry Video Game Nerd\'s alter ego is Board James.', 'boolean'),
('Entertainment: Board Games', 'false', 'medium', '19fcbd02-f01d-4bf2-ab72-83634469e174', 'In the game \'Racko,\' you may pick up any card from the discard pile.', 'boolean'),
('History', 'false', 'easy', '2173fa91-9160-44ff-bf04-cae926c4eef9', 'The United States was a member of the League of Nations.', 'boolean'),
('Geography', 'true', 'medium', '2cde91f6-6e51-4bda-bb02-7dd6d244b2bc', 'There are no roads in/out of Juneau, Alaska.', 'boolean'),
('Entertainment: Video Games', 'false', 'hard', '503e3651-593d-4cf4-9496-01ce67912b0f', 'All of these maps were in \'Tom Clancy\'s Rainbow Six Siege\' at its initial release: House, Clubhouse, Border, and Consulate.', 'boolean'),
('General Knowledge', 'false', 'medium', '52f39cc2-3a70-4269-8d76-5df8e17c0d14', 'The word \'news\' does not actually originate from the first letters of the four main directions on a compass (North, East, West, South).', 'boolean'),
('Entertainment: Video Games', 'false', 'easy', '6b2593c4-c1c5-4571-8d79-cc6593035b4e', 'In the Monster Hunter Series, it is possible to capture Elder Dragons.', 'boolean'),
('Entertainment: Books', 'false', 'easy', '6f831b1c-4329-49c4-bd73-590bed2477b7', 'Shub-Niggurath is a creature created by H.P. Lovecraft, not J.R.R. Tolkien, in his works, including \'The Call of Cthulhu\' and other stories.', 'boolean'),
('Entertainment: Video Games', 'false', 'easy', '76b2565d-e0ed-4d6b-a7ac-b81a0f927e7b', 'Tetris is the #1 best-selling video game of all-time.', 'boolean'),
('Entertainment: Video Games', 'false', 'medium', '7e60a61a-5b5a-452c-a77f-e22f091e410a', 'In Portal, the Companion Cube is not sentient', 'boolean'),
('Science: Mathematics', 'false', 'hard', '92e41ba4-e06a-4d5f-b365-54d6fd186f24', 'The binary number \'101001101\' is equivalent to the decimal number \'333\'.', 'boolean'),
('Entertainment: Cartoon and Animations', 'false', 'easy', '9aefc0a7-6110-4409-a4bf-73336335d633', 'Bill Cipher in the show \'Gravity Falls\' is the antagonist.', 'boolean'),
('History', 'true', 'easy', 'a236ebbe-aea8-4ac4-a114-f0f63b8fa5f1', 'The French Kingdom helped the United States gain their independence over Great Britain during the Revolutionary War.', 'boolean'),
('Geography', 'false', 'medium', 'b17a2cf8-9866-46a6-b63d-56ed252a167e', 'Seoul is the capital of North Korea.', 'boolean'),
('General Knowledge', 'false', 'easy', 'b4108344-5443-42e4-915e-2d1adefa00ab', 'Scotland voted to become an independent country during the referendum from September 2014.', 'boolean'),
('Entertainment: Music', 'true', 'easy', 'b623196c-a2c4-422b-9196-1bcf4e49c6b4', 'The 2011 movie \'The Adventures of Tintin\' was directed by Steven Spielberg.', 'boolean'),
('Politics', 'false', 'medium', 'cf2bbd73-6847-49fb-9e38-2a8ea5c55075', 'Jeb Bush was elected as Governor of Florida in 2002, starting his political career.', 'boolean'),
('Animals', 'false', 'easy', 'd12b7bf1-77b5-46c4-a660-710201360db6', 'Rabbits are rodents.', 'boolean'),
('General Knowledge', 'false', 'easy', 'e474a7ce-d023-4e23-afd5-f515d3ca15a9', 'Video streaming website YouTube was purchased in its entirety by Google for US$1.65 billion in stock.', 'boolean');

-- --------------------------------------------------------

--
-- Table structure for table `scores`
--

CREATE TABLE `scores` (
  `answered` int(11) NOT NULL,
  `correct_streak` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `incorrect_streak` int(11) NOT NULL,
  `scored` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `time` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `scores`
--

INSERT INTO `scores` (`answered`, `correct_streak`, `id`, `incorrect_streak`, `scored`, `user_id`, `time`) VALUES
(5, 4, 1, 0, 30, 1, '2024-07-21 10:38:51.000000'),
(5, 0, 2, 1, 4, 2, '2024-07-21 11:02:37.000000'),
(1, 1, 10, 0, 1, NULL, '2024-07-21 11:10:36.000000'),
(1, 1, 11, 0, 1, NULL, '2024-07-21 11:11:42.000000'),
(1, 1, 12, 0, 1, NULL, '2024-07-21 11:12:48.000000'),
(1, 1, 13, 0, 1, NULL, '2024-07-21 11:22:43.000000'),
(2, 2, 14, 0, 3, 4, '2024-07-21 11:34:28.000000'),
(1, 1, 15, 0, 1, 3, '2024-07-21 11:35:16.000000'),
(2, 2, 16, 0, 3, 5, '2024-07-21 11:56:37.000000'),
(3, 3, 17, 0, 6, 6, '2024-07-21 11:57:20.000000');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`) VALUES
(1, 'Dini'),
(2, 'John'),
(3, 'Rahma'),
(4, 'Mutia'),
(5, 'Henry'),
(6, 'Petra');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `scores`
--
ALTER TABLE `scores`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtkgoiahryd4yntgywbqyyw8o8` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `scores`
--
ALTER TABLE `scores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `scores`
--
ALTER TABLE `scores`
  ADD CONSTRAINT `FKtkgoiahryd4yntgywbqyyw8o8` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
