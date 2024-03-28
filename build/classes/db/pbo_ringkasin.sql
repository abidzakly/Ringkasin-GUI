-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 27, 2023 at 03:50 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbo_ringkasin`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `total_page` int(11) DEFAULT NULL,
  `pub_year` varchar(255) DEFAULT NULL,
  `isbn` varchar(20) DEFAULT NULL,
  `genre` varchar(255) NOT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id`, `title`, `author`, `total_page`, `pub_year`, `isbn`, `genre`, `filename`, `created_at`, `updated_at`) VALUES
(1, 'Normal People', 'Sally Rooney', 123, '2021', '123-4323-1', 'Romansa', 'normalPeople.png', '2023-12-24 23:51:41', '2023-12-26 12:33:00'),
(2, 'Berani Tidak Disukai', 'Fumikuro Hiragashi', 402, '2019', '9275610473', 'Non-Fiksi', 'beraniTidakDisukai.png', '2023-12-26 06:42:17', '2023-12-26 12:33:05'),
(3, 'Test', 'test', 33, '3333', '3333', 'test', 'test.png', '2023-12-26 06:44:08', '2023-12-26 12:33:11'),
(5, 'Mantappu Jiwa', 'Jerome Polin Sijabat', 354, '2019', '9315301835', 'Biografi', NULL, '2023-12-27 02:19:15', '2023-12-27 02:19:15'),
(10, 'The Midnight Library', 'John Doe', 489, '2015', '9182647183', 'Fantasy', NULL, '2023-12-26 13:59:57', '2023-12-26 13:59:57'),
(11, 'Educated', 'Tara Westover', 623, '2020', '9364510376', 'Biografi', NULL, '2023-12-26 15:38:40', '2023-12-26 15:38:40'),
(12, 'Graham Effect', 'Sophia Hermawa', 530, '2022', '9317463453', 'Romansa', NULL, '2023-12-27 02:31:23', '2023-12-27 02:31:23'),
(13, 'Bumi Bulat', 'Tere Liye', 282, '2015', '283212047', 'Fantasi', NULL, '2023-12-27 02:35:30', '2023-12-27 02:35:30'),
(14, 'Matahari', 'Tere Liye', 382, '2016', '9313427462', 'Fantasi', NULL, '2023-12-27 02:36:46', '2023-12-27 02:36:46'),
(15, 'SagaraaS', 'Tere Liye', 420, '2018', '93237642', 'Fantasi', NULL, '2023-12-27 02:38:13', '2023-12-27 02:38:13');

-- --------------------------------------------------------

--
-- Table structure for table `ringkasan`
--

CREATE TABLE `ringkasan` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ringkasan`
--

INSERT INTO `ringkasan` (`id`, `user_id`, `book_id`, `content`, `status`) VALUES
(1, 6, 1, 'Marianne Sheridan dan Connell Waldron bersekolah di sekolah menengah di sebuah kota kecil di Irlandia dan akan segera melanjutkan ke perguruan tinggi. Mereka cerdas, gemar membaca, tertarik dengan peristiwa dunia, dan peduli terhadap keadilan sosial. Marianne tinggal bersama saudara laki-lakinya dan ibunya yang janda. Mereka adalah keluarga kaya, namun saudara laki-lakinya, Alan, melakukan kekerasan verbal dan fisik terhadap Marianne, dan ibunya, bukannya ikut campur, malah memihak Alan. Marianne memiliki harga diri yang rendah karena bertahun-tahun menginternalisasi pelecehan verbal yang dilakukan kakaknya.\r\n\r\nIbu Connell, Lorraine, bekerja sebagai pembersih. Dia putus sekolah ketika dia hamil Connell dan tidak pernah memberi tahu siapa pun siapa ayahnya. Lorraine membersihkan rumah keluarga Sheridan dua kali seminggu. Karena dia tidak bisa mengemudi, Lorraine membutuhkan Connell untuk menjemputnya setelah dia selesai, jadi Connell dan Marianne sering bertemu. Connell sadar diri tentang asal usulnya, secara alami pemalu, tidak pandai bicara dalam percakapan, dan ragu-ragu.\r\n\r\nDi sekolah, Marianne sengaja antisosial dan dianggap tidak pantas, sedangkan Connell tampan dan atletis, dan karena itu populer meskipun dia merasa tidak aman. Di depan umum, Marianne mengabaikan Connell untuk menghindari merugikan status sosialnya, tetapi secara pribadi dia memberi tahu Connell secara terus terang bahwa dia memiliki perasaan terhadapnya. Cornell juga menyukai Marianne, tetapi dia menganggap hubungan mereka sebagai masalah pribadi dan tidak boleh dibagikan kepada seluruh dunia. Perasaannya sebagian didasarkan pada keinginan untuk melindungi status sosialnya, tetapi dia juga terhubung dengan Marianne dengan cara yang tidak dia pahami dan pahami sepenuhnya dengan orang lain.', 1),
(2, 10, 2, 'Kebiasaan kecil bisa mempunyai dampak yang sangat besar dalam hidup Anda.\r\nUntuk memulai, saya ingin Anda membayangkan sebuah pesawat bersiap lepas landas dari Los Angeles. Tujuan pesawat adalah Kota New York. Pilot memasukkan semua informasi yang benar ke dalam komputer pesawat, dan pesawat lepas landas menuju arah yang benar. Namun sekarang bayangkan, tidak lama setelah lepas landas, pilot secara tidak sengaja mengubah jalur penerbangannya sedikit. Dia hanya mengubahnya sebesar 3,5 derajat – yang hampir tidak berarti apa-apa, hanya beberapa kaki. Hidung pesawat sedikit bergeser ke satu sisi, dan tak seorang pun – baik pilot, maupun penumpang – memperhatikan apa pun.\r\n\r\nNamun dalam perjalanan melintasi Amerika Serikat, dampak dari perubahan kecil ini akan sangat besar. Di akhir perjalanan, para penumpang yang kebingungan – dan bahkan pilot yang kebingungan lagi – akan mendarat di Washington DC, bukan New York City.\r\n\r\nJadi, mengapa aku memberitahumu hal ini?\r\n\r\nHal ini karena – sama seperti pilot yang kebingungan – kita tidak menyadari adanya perubahan kecil dalam hidup kita. Perubahan kecil hanya meninggalkan dampak langsung yang tidak berarti. Jika Anda tidak bugar hari ini, dan jogging selama 20 menit, besok Anda tetap bugar. Jika Anda makan pizza ukuran keluarga untuk makan malam, tidak akan membuat Anda kelebihan berat badan dalam semalam.\r\n\r\nNamun jika kita mengulangi perilaku kecil ini hari demi hari, pilihan kita akan menghasilkan hasil yang besar. Makan pizza setiap hari, dan kemungkinan besar berat badan Anda akan bertambah setelah satu tahun. Lakukan joging selama 20 menit setiap hari, dan pada akhirnya Anda akan menjadi lebih ramping dan bugar, meskipun Anda tidak menyadari adanya perubahan.\r\n\r\nAnda mungkin telah menemukan pemahaman utama di sini: kebiasaan kecil dapat memberikan dampak yang sangat kuat dalam hidup Anda – dan Anda belum tentu melihat dampak ini terjadi secara real-time. Anda hanya akan melihat hasil dari kebiasaan Anda setelah beberapa saat.\r\n\r\nKini, kami tahu bahwa tidak melihat dampak dari upaya Anda dapat membuat Anda putus asa. Jika hal ini terjadi pada Anda – jika Anda merasa putus asa karena tidak adanya perubahan positif dalam waktu dekat – maka penting bagi Anda untuk mencoba fokus pada arah yang Anda capai saat ini, bukan pada hasil yang Anda capai saat ini.\r\n\r\nKatakanlah Anda mempunyai sedikit uang di bank. Tapi Anda menabung sesuatu setiap bulan. Hasil Anda saat ini mungkin tidak terlalu bagus – sarang Anda masih cukup kecil. Namun Anda bisa yakin bahwa lintasan Anda benar. Teruslah berjalan ke arah ini dan, dalam beberapa bulan atau beberapa tahun, Anda akan melihat peningkatan yang besar. Ketika kurangnya kemajuan membuat Anda kecewa, ingatlah bahwa Anda melakukan hal yang benar dan bergerak ke arah yang benar.\r\n\r\nNamun bagaimana caranya agar Anda berada pada jalur yang benar? Anda perlu mengembangkan kebiasaan. Sebentar lagi, kita akan mempelajari cara pembuatannya', 1),
(3, 9, 5, 'Jerome Poline Sijabat, lahir di Jakarta, 2 Mei 1998. Lahir ditengah situasi yang sulit karena krisis moneter pada Mei 1998. Namun didukung oleh keluarga yang selalu mendukungnya, Jerome mendapatkan beasiswa penuh program sarjana Matematika Terapan Mitsui Bussan di Waseda University Jepang. Merantau di Negeri Sakura, Jerome memulai perjalanan kariernya di Youtube dengan channel âNihongo Mantappuâ pada tahun 2018.\r\n\r\nNihongo Mantappu kini telah mencapai lebih dari 7,8 juta subscriber yang mengambil tema tentang Jepang, Pendidikan, dan matematika. Alasan Jerome menulis buku ini yaitu untuk menceritakan bagaimana dia menghadapi setiap persoalan dihidupnya. Dimulai dari Jerome lahir yang dekat dengan kerusuhan pada 1998.\r\n\r\nBagaimana keluarga berusaha menyekolahkannya dengan kondisi ekonomi yang terbatas, sampai pada akhirnya Jerome berhasil mendapatkan beasiswa penuh S1 di Jepang. Buku Mantappu Jiwa tidak hanya menceritakan tentang cerita sedih seorang Jerome Poline Sijabat.\r\n\r\nNamun Mantappu Jiwa ini adalah cacatan perjuangan Jerome Poline dari semasa hidupnya yang penuh liku. Penuh perjuangan hingga dia mampu menjadi orang hebat seperti sekarang. Buku Mantappu Jiwa karya Jerome Poline ini berisi kisah hidup Jerome sejak dia lahir sampai bisa kuliah di Jepang dan menjadi Youtuber terkenal. Ternyata keinginan Jerome untuk kuliah sudah ada sejak dia Sekolah Dasar.\r\n\r\nKarena alasan yang sangat sederhana, yaitu dia ingin pergi ke luar negeri seperti teman-temannya. Kisahnya pun mengalir hingga bagaimana Jerome mencari beasiswa S1 penuh di luar negeri sejak Sekolah Menengah Pertama, perjuangannya belajar matematika dan ikut banyak lomba sejak Sekolah Menengah Atas, serta jatuh bangunnya untuk mendapatkan beasiswa NUS, NTU, dan akhirnya mendapat beasiswa di Mitsui Busan ke Jepang. Setelah sampai di Jepang dengan beasiswa penuh, perjuangan Jerome Poline masih belum berakhir.\r\n\r\nJerome masih harus belajar Bahasa Jepang dari nol. Belajar Matematika, Kimia, dan Fisika dalam Bahasa Jepang. Beradaptasi di negara asing sampai akhirnya berhasil lulus menjadi mahasiswa di Waseda University. Di waktu senggang, Jerome membuat konten Youtube di channelnya yaitu Nihongo Mantappu, yang sekarang memiliki hampir 7,88 juta subscribers.\r\n\r\nBagi penonton Youtube Nihongo Mantappu, buku ini sebenarnya tidak menceritakan hal yang baru dari seorang Jerome. Jerome sendiri sudah membuat video tentang kisahnya mendapatkan beasiswa di bagian Cerita Perjuangan Beasiswa Full Kuliah ke Luar Negeri. Tapi yang menarik dari buku ini yaitu lebih menonjolkan tentang kerja keras Jerome untuk mendapatkan beasiswa. Cerita kegagalan yang biasanya tidak diceritakan mendetail, di buku tersebut dituliskan bahwa hasil yang didapatkan tidak dapat diperoleh secara instan.', 1),
(7, 6, 5, 'Jerome Poline Sijabat, lahir di Jakarta, 2 Mei 1998. Lahir ditengah situasi yang sulit karena krisis moneter pada Mei 1998. Namun didukung oleh keluarga yang selalu mendukungnya, Jerome mendapatkan beasiswa penuh program sarjana Matematika Terapan Mitsui Bussan di Waseda University Jepang. Merantau di Negeri Sakura, Jerome memulai perjalanan kariernya di Youtube dengan channel âNihongo Mantappuâ pada tahun 2018.\r\n\r\nNihongo Mantappu kini telah mencapai lebih dari 7,8 juta subscriber yang mengambil tema tentang Jepang, Pendidikan, dan matematika. Alasan Jerome menulis buku ini yaitu untuk menceritakan bagaimana dia menghadapi setiap persoalan dihidupnya. Dimulai dari Jerome lahir yang dekat dengan kerusuhan pada 1998.\r\n\r\nBagaimana keluarga berusaha menyekolahkannya dengan kondisi ekonomi yang terbatas, sampai pada akhirnya Jerome berhasil mendapatkan beasiswa penuh S1 di Jepang. Buku Mantappu Jiwa tidak hanya menceritakan tentang cerita sedih seorang Jerome Poline Sijabat.\r\n\r\nNamun Mantappu Jiwa ini adalah cacatan perjuangan Jerome Poline dari semasa hidupnya yang penuh liku. Penuh perjuangan hingga dia mampu menjadi orang hebat seperti sekarang. Buku Mantappu Jiwa karya Jerome Poline ini berisi kisah hidup Jerome sejak dia lahir sampai bisa kuliah di Jepang dan menjadi Youtuber terkenal. Ternyata keinginan Jerome untuk kuliah sudah ada sejak dia Sekolah Dasar.\r\n\r\nKarena alasan yang sangat sederhana, yaitu dia ingin pergi ke luar negeri seperti teman-temannya. Kisahnya pun mengalir hingga bagaimana Jerome mencari beasiswa S1 penuh di luar negeri sejak Sekolah Menengah Pertama, perjuangannya belajar matematika dan ikut banyak lomba sejak Sekolah Menengah Atas, serta jatuh bangunnya untuk mendapatkan beasiswa NUS, NTU, dan akhirnya mendapat beasiswa di Mitsui Busan ke Jepang. Setelah sampai di Jepang dengan beasiswa penuh, perjuangan Jerome Poline masih belum berakhir.\r\n\r\nJerome masih harus belajar Bahasa Jepang dari nol. Belajar Matematika, Kimia, dan Fisika dalam Bahasa Jepang. Beradaptasi di negara asing sampai akhirnya berhasil lulus menjadi mahasiswa di Waseda University. Di waktu senggang, Jerome membuat konten Youtube di channelnya yaitu Nihongo Mantappu, yang sekarang memiliki hampir 7,88 juta subscribers.\r\n\r\nBagi penonton Youtube Nihongo Mantappu, buku ini sebenarnya tidak menceritakan hal yang baru dari seorang Jerome. Jerome sendiri sudah membuat video tentang kisahnya mendapatkan beasiswa di bagian âCerita Perjuangan Beasiswa Full Kuliah ke Luar Negeriâ. Tapi yang menarik dari buku ini yaitu lebih menonjolkan tentang kerja keras Jerome untuk mendapatkan beasiswa. Cerita kegagalan yang biasanya tidak diceritakan mendetail, di buku tersebut dituliskan bahwa hasil yang didapatkan tidak dapat diperoleh secara instan.', 0),
(8, 8, 5, 'Jerome Poline Sijabat, lahir di Jakarta, 2 Mei 1998. Lahir ditengah situasi yang sulit karena krisis moneter pada Mei 1998. Namun didukung oleh keluarga yang selalu mendukungnya, Jerome mendapatkan beasiswa penuh program sarjana Matematika Terapan Mitsui Bussan di Waseda University Jepang. Merantau di Negeri Sakura, Jerome memulai perjalanan kariernya di Youtube dengan channel âNihongo Mantappuâ pada tahun 2018.\r\n\r\nNihongo Mantappu kini telah mencapai lebih dari 7,8 juta subscriber yang mengambil tema tentang Jepang, Pendidikan, dan matematika. Alasan Jerome menulis buku ini yaitu untuk menceritakan bagaimana dia menghadapi setiap persoalan dihidupnya. Dimulai dari Jerome lahir yang dekat dengan kerusuhan pada 1998.\r\n\r\nBagaimana keluarga berusaha menyekolahkannya dengan kondisi ekonomi yang terbatas, sampai pada akhirnya Jerome berhasil mendapatkan beasiswa penuh S1 di Jepang. Buku Mantappu Jiwa tidak hanya menceritakan tentang cerita sedih seorang Jerome Poline Sijabat.\r\n\r\nNamun Mantappu Jiwa ini adalah cacatan perjuangan Jerome Poline dari semasa hidupnya yang penuh liku. Penuh perjuangan hingga dia mampu menjadi orang hebat seperti sekarang. Buku Mantappu Jiwa karya Jerome Poline ini berisi kisah hidup Jerome sejak dia lahir sampai bisa kuliah di Jepang dan menjadi Youtuber terkenal. Ternyata keinginan Jerome untuk kuliah sudah ada sejak dia Sekolah Dasar.\r\n\r\nKarena alasan yang sangat sederhana, yaitu dia ingin pergi ke luar negeri seperti teman-temannya. Kisahnya pun mengalir hingga bagaimana Jerome mencari beasiswa S1 penuh di luar negeri sejak Sekolah Menengah Pertama, perjuangannya belajar matematika dan ikut banyak lomba sejak Sekolah Menengah Atas, serta jatuh bangunnya untuk mendapatkan beasiswa NUS, NTU, dan akhirnya mendapat beasiswa di Mitsui Busan ke Jepang. Setelah sampai di Jepang dengan beasiswa penuh, perjuangan Jerome Poline masih belum berakhir.\r\n\r\nJerome masih harus belajar Bahasa Jepang dari nol. Belajar Matematika, Kimia, dan Fisika dalam Bahasa Jepang. Beradaptasi di negara asing sampai akhirnya berhasil lulus menjadi mahasiswa di Waseda University. Di waktu senggang, Jerome membuat konten Youtube di channelnya yaitu Nihongo Mantappu, yang sekarang memiliki hampir 7,88 juta subscribers.\r\n\r\nBagi penonton Youtube Nihongo Mantappu, buku ini sebenarnya tidak menceritakan hal yang baru dari seorang Jerome. Jerome sendiri sudah membuat video tentang kisahnya mendapatkan beasiswa di bagian âCerita Perjuangan Beasiswa Full Kuliah ke Luar Negeriâ. Tapi yang menarik dari buku ini yaitu lebih menonjolkan tentang kerja keras Jerome untuk mendapatkan beasiswa. Cerita kegagalan yang biasanya tidak diceritakan mendetail, di buku tersebut dituliskan bahwa hasil yang didapatkan tidak dapat diperoleh secara instan.', 2),
(9, 8, 2, 'Kebiasaan kecil bisa mempunyai dampak yang sangat besar dalam hidup Anda.\r\nUntuk memulai, saya ingin Anda membayangkan sebuah pesawat bersiap lepas landas dari Los Angeles. Tujuan pesawat adalah Kota New York. Pilot memasukkan semua informasi yang benar ke dalam komputer pesawat, dan pesawat lepas landas menuju arah yang benar. Namun sekarang bayangkan, tidak lama setelah lepas landas, pilot secara tidak sengaja mengubah jalur penerbangannya sedikit. Dia hanya mengubahnya sebesar 3,5 derajat – yang hampir tidak berarti apa-apa, hanya beberapa kaki. Hidung pesawat sedikit bergeser ke satu sisi, dan tak seorang pun – baik pilot, maupun penumpang – memperhatikan apa pun.\r\n\r\nNamun dalam perjalanan melintasi Amerika Serikat, dampak dari perubahan kecil ini akan sangat besar. Di akhir perjalanan, para penumpang yang kebingungan – dan bahkan pilot yang kebingungan lagi – akan mendarat di Washington DC, bukan New York City.\r\n\r\nJadi, mengapa aku memberitahumu hal ini?\r\n\r\nHal ini karena – sama seperti pilot yang kebingungan – kita tidak menyadari adanya perubahan kecil dalam hidup kita. Perubahan kecil hanya meninggalkan dampak langsung yang tidak berarti. Jika Anda tidak bugar hari ini, dan jogging selama 20 menit, besok Anda tetap bugar. Jika Anda makan pizza ukuran keluarga untuk makan malam, tidak akan membuat Anda kelebihan berat badan dalam semalam.\r\n\r\nNamun jika kita mengulangi perilaku kecil ini hari demi hari, pilihan kita akan menghasilkan hasil yang besar. Makan pizza setiap hari, dan kemungkinan besar berat badan Anda akan bertambah setelah satu tahun. Lakukan joging selama 20 menit setiap hari, dan pada akhirnya Anda akan menjadi lebih ramping dan bugar, meskipun Anda tidak menyadari adanya perubahan.\r\n\r\nAnda mungkin telah menemukan pemahaman utama di sini: kebiasaan kecil dapat memberikan dampak yang sangat kuat dalam hidup Anda – dan Anda belum tentu melihat dampak ini terjadi secara real-time. Anda hanya akan melihat hasil dari kebiasaan Anda setelah beberapa saat.\r\n\r\nKini, kami tahu bahwa tidak melihat dampak dari upaya Anda dapat membuat Anda putus asa. Jika hal ini terjadi pada Anda – jika Anda merasa putus asa karena tidak adanya perubahan positif dalam waktu dekat – maka penting bagi Anda untuk mencoba fokus pada arah yang Anda capai saat ini, bukan pada hasil yang Anda capai saat ini.\r\n\r\nKatakanlah Anda mempunyai sedikit uang di bank. Tapi Anda menabung sesuatu setiap bulan. Hasil Anda saat ini mungkin tidak terlalu bagus – sarang Anda masih cukup kecil. Namun Anda bisa yakin bahwa lintasan Anda benar. Teruslah berjalan ke arah ini dan, dalam beberapa bulan atau beberapa tahun, Anda akan melihat peningkatan yang besar. Ketika kurangnya kemajuan membuat Anda kecewa, ingatlah bahwa Anda melakukan hal yang benar dan bergerak ke arah yang benar.\r\n\r\nNamun bagaimana caranya agar Anda berada pada jalur yang benar? Anda perlu mengembangkan kebiasaan. Sebentar lagi, kita akan mempelajari cara pembuatannya', 2),
(10, 6, 2, 'Kebiasaan kecil bisa mempunyai dampak yang sangat besar dalam hidup Anda.\r\nUntuk memulai, saya ingin Anda membayangkan sebuah pesawat bersiap lepas landas dari Los Angeles. Tujuan pesawat adalah Kota New York. Pilot memasukkan semua informasi yang benar ke dalam komputer pesawat, dan pesawat lepas landas menuju arah yang benar. Namun sekarang bayangkan, tidak lama setelah lepas landas, pilot secara tidak sengaja mengubah jalur penerbangannya sedikit. Dia hanya mengubahnya sebesar 3,5 derajat – yang hampir tidak berarti apa-apa, hanya beberapa kaki. Hidung pesawat sedikit bergeser ke satu sisi, dan tak seorang pun – baik pilot, maupun penumpang – memperhatikan apa pun.\r\n\r\nNamun dalam perjalanan melintasi Amerika Serikat, dampak dari perubahan kecil ini akan sangat besar. Di akhir perjalanan, para penumpang yang kebingungan – dan bahkan pilot yang kebingungan lagi – akan mendarat di Washington DC, bukan New York City.\r\n\r\nJadi, mengapa aku memberitahumu hal ini?\r\n\r\nHal ini karena – sama seperti pilot yang kebingungan – kita tidak menyadari adanya perubahan kecil dalam hidup kita. Perubahan kecil hanya meninggalkan dampak langsung yang tidak berarti. Jika Anda tidak bugar hari ini, dan jogging selama 20 menit, besok Anda tetap bugar. Jika Anda makan pizza ukuran keluarga untuk makan malam, tidak akan membuat Anda kelebihan berat badan dalam semalam.\r\n\r\nNamun jika kita mengulangi perilaku kecil ini hari demi hari, pilihan kita akan menghasilkan hasil yang besar. Makan pizza setiap hari, dan kemungkinan besar berat badan Anda akan bertambah setelah satu tahun. Lakukan joging selama 20 menit setiap hari, dan pada akhirnya Anda akan menjadi lebih ramping dan bugar, meskipun Anda tidak menyadari adanya perubahan.\r\n\r\nAnda mungkin telah menemukan pemahaman utama di sini: kebiasaan kecil dapat memberikan dampak yang sangat kuat dalam hidup Anda – dan Anda belum tentu melihat dampak ini terjadi secara real-time. Anda hanya akan melihat hasil dari kebiasaan Anda setelah beberapa saat.\r\n\r\nKini, kami tahu bahwa tidak melihat dampak dari upaya Anda dapat membuat Anda putus asa. Jika hal ini terjadi pada Anda – jika Anda merasa putus asa karena tidak adanya perubahan positif dalam waktu dekat – maka penting bagi Anda untuk mencoba fokus pada arah yang Anda capai saat ini, bukan pada hasil yang Anda capai saat ini.\r\n\r\nKatakanlah Anda mempunyai sedikit uang di bank. Tapi Anda menabung sesuatu setiap bulan. Hasil Anda saat ini mungkin tidak terlalu bagus – sarang Anda masih cukup kecil. Namun Anda bisa yakin bahwa lintasan Anda benar. Teruslah berjalan ke arah ini dan, dalam beberapa bulan atau beberapa tahun, Anda akan melihat peningkatan yang besar. Ketika kurangnya kemajuan membuat Anda kecewa, ingatlah bahwa Anda melakukan hal yang benar dan bergerak ke arah yang benar.\r\n\r\nNamun bagaimana caranya agar Anda berada pada jalur yang benar? Anda perlu mengembangkan kebiasaan. Sebentar lagi, kita akan mempelajari cara pembuatannya', 0),
(11, 8, 10, 'Hari yang Mengerikan dan Perpustakaan yang Tak Terduga\r\nNora kini berusia 35 tahun. Dia berada di kamarnya menelusuri kehidupan bahagia orang lain ketika ada ketukan di pintu.\r\n\r\nPada awalnya, dia senang melihatnya – itu Ash, seorang pria yang pernah mengajaknya kencan, tapi dia menolak karena dia sudah menjalin hubungan. Mungkin dia akan bertanya lagi padanya. Tapi tidak. Dia punya kabar buruk. Dia menemukan kucingnya, Voltaire, mati di jalan. Nora tahu dia seharusnya merasakan emosi seperti rasa kasihan dan putus asa, namun sebaliknya, dia mendapati dirinya merasakan sesuatu yang sangat berbeda: iri hati.\r\n\r\nKeesokan harinya, kehidupan Nora berubah dari buruk menjadi lebih buruk. Dia dipecat dari pekerjaannya. Dia berjalan keliling kota, merenungkan hidupnya. Dia memikirkan mantannya, Dan, yang dia tolak hanya dua hari sebelum mereka menikah. Dia bertemu sahabat kakaknya Joe, Ravi. Mereka bertiga, bersama pacar Ravi, pernah bermain di band bernama The Labyrinths – tapi Nora berhenti. Ravi jelas masih kesal dengan hal itu. Dia mengetahui bahwa Joe telah berada di kota dan tidak mengunjunginya.\r\n\r\nDia mengirim pesan kepada sahabatnya, Izzy – Nora menolak kesempatan untuk pindah ke Australia bersamanya – tetapi meskipun Izzy membaca pesan tersebut, tidak ada balasan.\r\n\r\nDia mendapat telepon dari ibu satu-satunya murid pianonya, Leo, yang memberitahunya bahwa pelajarannya dibatalkan.\r\n\r\nTetangganya yang lanjut usia kemudian memberi tahu Nora bahwa dia tidak perlu lagi mengambilkan obat untuknya.\r\n\r\nDia merasa semua orang akan lebih baik tanpanya. Malam itu, dia menulis catatan bunuh diri dan mengalami overdosis.\r\n\r\nNora menemukan dirinya berada di lingkungan asing. Ada gedung yang penuh dengan buku dengan pustakawan yang mirip dengan Nyonya Elm versi muda. Dia mengetahui bahwa dia berada di tempat antara hidup dan mati – Perpustakaan Tengah Malam. Nyonya Elm mengatakan kepadanya bahwa dari sini, dia dapat berpindah di antara kemungkinan kehidupannya yang tak terbatas dan mungkin dapat menemukan kehidupan yang layak dijalani. Nyonya Elm menunjukkan padanya sebuah buku berjudul The Book of Regrets yang berisi semua hal yang Nora ingin dia lakukan atau tidak lakukan. Nora kewalahan karenanya. Nyonya Elm mendorongnya untuk mengunjungi beberapa kehidupan alternatif untuk mencari tahu siapa dia sebenarnya dan apa yang dia inginkan.\r\n\r\nNora menyadari dia menyesal meninggalkan Dan dan tidak bekerja sama untuk mencapai impian memiliki pub pedesaan. Nyonya Elm memberikan Nora sebuah buku. Dia membaca baris pertama, dan tiba-tiba dia berdiri di luar sebuah pub: The Three Horseshoes.\', 1)\r\n(1, 4, \'Pendidikan pada dasarnya bersifat retrospektif, terdiri dari kenangan Tara Westover tentang masa lalunya. Dia menceritakan kisah peristiwa-peristiwa dalam hidupnya dari sudut pandang di akhir usia dua puluhan, sesekali menyela untuk mengomentari proses mencoba mendapatkan versi masa lalu yang akurat. Tara lahir sebagai anak bungsu dari tujuh bersaudara dari orang tua yang dia sebut sebagai Faye dan Gene (nama samaran). Keluarga Westover tinggal di sebuah pertanian di pedesaan Idaho, tempat Gene mencari nafkah dengan menyelamatkan besi tua sementara Faye bekerja sebagai bidan dan tabib herbal tanpa izin. Gene menderita ketakutan paranoid terhadap campur tangan pemerintah federal, dan akibatnya dia menolak mengizinkan anak-anaknya bersekolah, menerima akta kelahiran, atau menerima perawatan medis. Gene juga seorang Mormon taat yang percaya pada kemandirian radikal dan Hari Penghakiman yang akan datang.\r\n\r\nPergeseran dalam dinamika keluarga Westover mulai terlihat ketika Tara berusia sekitar sembilan tahun. Pekerjaan ibunya sebagai bidan meningkatkan rasa kemandiriannya, namun setelah mengalami cedera otak yang serius dan tidak diobati dalam kecelakaan mobil, Faye mulai kehilangan kepercayaan pada keterampilannya, dan fokus pada penggunaan pengobatan herbal dan bentuk penyembuhan intuitif. Sekitar waktu ini, Tyler (putra ketiga) mengumumkan bahwa dia akan kuliah, yang membuatnya terasing dari keluarganya. Ketidakhadiran Tyler memaksa Tara untuk lebih terlibat dalam membantu ayahnya mengerjakan pekerjaan pembongkaran, yang membuatnya terus-menerus terkena kemungkinan cedera berbahaya. Hal ini juga membuatnya semakin penasaran untuk melanjutkan pendidikannya. Ketika Tara berusia sepuluh tahun, dia mengatakan kepada ayahnya yang tidak setuju bahwa dia ingin mulai bersekolah, tetapi tidak ada ide yang muncul.\r\n\r\nKetika Tara tumbuh remaja, dia memperoleh lebih banyak kemandirian dari keluarganya karena mengambil berbagai pekerjaan dan menekuni bidang menyanyi dan teater musikal di komunitas lokal. Namun, hidupnya didominasi oleh peraturan ketat dan doktrin agama yang diterapkan ayahnya, dan Tara sering kali khawatir akan menjadi berdosa. Ketika Tara berusia tiga belas tahun, kakak laki-lakinya Shawn pindah kembali ke rumah. Awalnya Shawn dan Tara dekat dan banyak menghabiskan waktu bersama. Namun, ketika Tara berusia sekitar lima belas tahun, Shawn mulai melakukan kekerasan fisik terhadapnya. Perilakunya semakin parah setelah Shawn mengalami cedera kepala. Tyler akhirnya menyadari bahwa Shawn menyakiti Tara, dan dia mendesak Tara untuk secara serius mempertimbangkan untuk mendaftar ke perguruan tinggi dan menjauh dari keluarga. Meskipun pada awalnya dia tidak yakin, Tara mulai belajar dan akhirnya diterima di Universitas Brigham Young, setelah menyatakan dirinya bersekolah di rumah.', 0),
(12, 6, 10, 'Hari yang Mengerikan dan Perpustakaan yang Tak Terduga\r\nNora kini berusia 35 tahun. Dia berada di kamarnya menelusuri kehidupan bahagia orang lain ketika ada ketukan di pintu.\r\n\r\nPada awalnya, dia senang melihatnya – itu Ash, seorang pria yang pernah mengajaknya kencan, tapi dia menolak karena dia sudah menjalin hubungan. Mungkin dia akan bertanya lagi padanya. Tapi tidak. Dia punya kabar buruk. Dia menemukan kucingnya, Voltaire, mati di jalan. Nora tahu dia seharusnya merasakan emosi seperti rasa kasihan dan putus asa, namun sebaliknya, dia mendapati dirinya merasakan sesuatu yang sangat berbeda: iri hati.\r\n\r\nKeesokan harinya, kehidupan Nora berubah dari buruk menjadi lebih buruk. Dia dipecat dari pekerjaannya. Dia berjalan keliling kota, merenungkan hidupnya. Dia memikirkan mantannya, Dan, yang dia tolak hanya dua hari sebelum mereka menikah. Dia bertemu sahabat kakaknya Joe, Ravi. Mereka bertiga, bersama pacar Ravi, pernah bermain di band bernama The Labyrinths – tapi Nora berhenti. Ravi jelas masih kesal dengan hal itu. Dia mengetahui bahwa Joe telah berada di kota dan tidak mengunjunginya.\r\n\r\nDia mengirim pesan kepada sahabatnya, Izzy – Nora menolak kesempatan untuk pindah ke Australia bersamanya – tetapi meskipun Izzy membaca pesan tersebut, tidak ada balasan.\r\n\r\nDia mendapat telepon dari ibu satu-satunya murid pianonya, Leo, yang memberitahunya bahwa pelajarannya dibatalkan.\r\n\r\nTetangganya yang lanjut usia kemudian memberi tahu Nora bahwa dia tidak perlu lagi mengambilkan obat untuknya.\r\n\r\nDia merasa semua orang akan lebih baik tanpanya. Malam itu, dia menulis catatan bunuh diri dan mengalami overdosis.\r\n\r\nNora menemukan dirinya berada di lingkungan asing. Ada gedung yang penuh dengan buku dengan pustakawan yang mirip dengan Nyonya Elm versi muda. Dia mengetahui bahwa dia berada di tempat antara hidup dan mati – Perpustakaan Tengah Malam. Nyonya Elm mengatakan kepadanya bahwa dari sini, dia dapat berpindah di antara kemungkinan kehidupannya yang tak terbatas dan mungkin dapat menemukan kehidupan yang layak dijalani. Nyonya Elm menunjukkan padanya sebuah buku berjudul The Book of Regrets yang berisi semua hal yang Nora ingin dia lakukan atau tidak lakukan. Nora kewalahan karenanya. Nyonya Elm mendorongnya untuk mengunjungi beberapa kehidupan alternatif untuk mencari tahu siapa dia sebenarnya dan apa yang dia inginkan.\r\n\r\nNora menyadari dia menyesal meninggalkan Dan dan tidak bekerja sama untuk mencapai impian memiliki pub pedesaan. Nyonya Elm memberikan Nora sebuah buku. Dia membaca baris pertama, dan tiba-tiba dia berdiri di luar sebuah pub: The Three Horseshoes.\', 1)\r\n(1, 4, \'Pendidikan pada dasarnya bersifat retrospektif, terdiri dari kenangan Tara Westover tentang masa lalunya. Dia menceritakan kisah peristiwa-peristiwa dalam hidupnya dari sudut pandang di akhir usia dua puluhan, sesekali menyela untuk mengomentari proses mencoba mendapatkan versi masa lalu yang akurat. Tara lahir sebagai anak bungsu dari tujuh bersaudara dari orang tua yang dia sebut sebagai Faye dan Gene (nama samaran). Keluarga Westover tinggal di sebuah pertanian di pedesaan Idaho, tempat Gene mencari nafkah dengan menyelamatkan besi tua sementara Faye bekerja sebagai bidan dan tabib herbal tanpa izin. Gene menderita ketakutan paranoid terhadap campur tangan pemerintah federal, dan akibatnya dia menolak mengizinkan anak-anaknya bersekolah, menerima akta kelahiran, atau menerima perawatan medis. Gene juga seorang Mormon taat yang percaya pada kemandirian radikal dan Hari Penghakiman yang akan datang.\r\n\r\nPergeseran dalam dinamika keluarga Westover mulai terlihat ketika Tara berusia sekitar sembilan tahun. Pekerjaan ibunya sebagai bidan meningkatkan rasa kemandiriannya, namun setelah mengalami cedera otak yang serius dan tidak diobati dalam kecelakaan mobil, Faye mulai kehilangan kepercayaan pada keterampilannya, dan fokus pada penggunaan pengobatan herbal dan bentuk penyembuhan intuitif. Sekitar waktu ini, Tyler (putra ketiga) mengumumkan bahwa dia akan kuliah, yang membuatnya terasing dari keluarganya. Ketidakhadiran Tyler memaksa Tara untuk lebih terlibat dalam membantu ayahnya mengerjakan pekerjaan pembongkaran, yang membuatnya terus-menerus terkena kemungkinan cedera berbahaya. Hal ini juga membuatnya semakin penasaran untuk melanjutkan pendidikannya. Ketika Tara berusia sepuluh tahun, dia mengatakan kepada ayahnya yang tidak setuju bahwa dia ingin mulai bersekolah, tetapi tidak ada ide yang muncul.\r\n\r\nKetika Tara tumbuh remaja, dia memperoleh lebih banyak kemandirian dari keluarganya karena mengambil berbagai pekerjaan dan menekuni bidang menyanyi dan teater musikal di komunitas lokal. Namun, hidupnya didominasi oleh peraturan ketat dan doktrin agama yang diterapkan ayahnya, dan Tara sering kali khawatir akan menjadi berdosa. Ketika Tara berusia tiga belas tahun, kakak laki-lakinya Shawn pindah kembali ke rumah. Awalnya Shawn dan Tara dekat dan banyak menghabiskan waktu bersama. Namun, ketika Tara berusia sekitar lima belas tahun, Shawn mulai melakukan kekerasan fisik terhadapnya. Perilakunya semakin parah setelah Shawn mengalami cedera kepala. Tyler akhirnya menyadari bahwa Shawn menyakiti Tara, dan dia mendesak Tara untuk secara serius mempertimbangkan untuk mendaftar ke perguruan tinggi dan menjauh dari keluarga. Meskipun pada awalnya dia tidak yakin, Tara mulai belajar dan akhirnya diterima di Universitas Brigham Young, setelah menyatakan dirinya bersekolah di rumah.', 1),
(13, 9, 10, 'Hari yang Mengerikan dan Perpustakaan yang Tak Terduga\r\nNora kini berusia 35 tahun. Dia berada di kamarnya menelusuri kehidupan bahagia orang lain ketika ada ketukan di pintu.\r\n\r\nPada awalnya, dia senang melihatnya – itu Ash, seorang pria yang pernah mengajaknya kencan, tapi dia menolak karena dia sudah menjalin hubungan. Mungkin dia akan bertanya lagi padanya. Tapi tidak. Dia punya kabar buruk. Dia menemukan kucingnya, Voltaire, mati di jalan. Nora tahu dia seharusnya merasakan emosi seperti rasa kasihan dan putus asa, namun sebaliknya, dia mendapati dirinya merasakan sesuatu yang sangat berbeda: iri hati.\r\n\r\nKeesokan harinya, kehidupan Nora berubah dari buruk menjadi lebih buruk. Dia dipecat dari pekerjaannya. Dia berjalan keliling kota, merenungkan hidupnya. Dia memikirkan mantannya, Dan, yang dia tolak hanya dua hari sebelum mereka menikah. Dia bertemu sahabat kakaknya Joe, Ravi. Mereka bertiga, bersama pacar Ravi, pernah bermain di band bernama The Labyrinths – tapi Nora berhenti. Ravi jelas masih kesal dengan hal itu. Dia mengetahui bahwa Joe telah berada di kota dan tidak mengunjunginya.\r\n\r\nDia mengirim pesan kepada sahabatnya, Izzy – Nora menolak kesempatan untuk pindah ke Australia bersamanya – tetapi meskipun Izzy membaca pesan tersebut, tidak ada balasan.\r\n\r\nDia mendapat telepon dari ibu satu-satunya murid pianonya, Leo, yang memberitahunya bahwa pelajarannya dibatalkan.\r\n\r\nTetangganya yang lanjut usia kemudian memberi tahu Nora bahwa dia tidak perlu lagi mengambilkan obat untuknya.\r\n\r\nDia merasa semua orang akan lebih baik tanpanya. Malam itu, dia menulis catatan bunuh diri dan mengalami overdosis.\r\n\r\nNora menemukan dirinya berada di lingkungan asing. Ada gedung yang penuh dengan buku dengan pustakawan yang mirip dengan Nyonya Elm versi muda. Dia mengetahui bahwa dia berada di tempat antara hidup dan mati – Perpustakaan Tengah Malam. Nyonya Elm mengatakan kepadanya bahwa dari sini, dia dapat berpindah di antara kemungkinan kehidupannya yang tak terbatas dan mungkin dapat menemukan kehidupan yang layak dijalani. Nyonya Elm menunjukkan padanya sebuah buku berjudul The Book of Regrets yang berisi semua hal yang Nora ingin dia lakukan atau tidak lakukan. Nora kewalahan karenanya. Nyonya Elm mendorongnya untuk mengunjungi beberapa kehidupan alternatif untuk mencari tahu siapa dia sebenarnya dan apa yang dia inginkan.\r\n\r\nNora menyadari dia menyesal meninggalkan Dan dan tidak bekerja sama untuk mencapai impian memiliki pub pedesaan. Nyonya Elm memberikan Nora sebuah buku. Dia membaca baris pertama, dan tiba-tiba dia berdiri di luar sebuah pub: The Three Horseshoes.\', 1)\r\n(1, 4, \'Pendidikan pada dasarnya bersifat retrospektif, terdiri dari kenangan Tara Westover tentang masa lalunya. Dia menceritakan kisah peristiwa-peristiwa dalam hidupnya dari sudut pandang di akhir usia dua puluhan, sesekali menyela untuk mengomentari proses mencoba mendapatkan versi masa lalu yang akurat. Tara lahir sebagai anak bungsu dari tujuh bersaudara dari orang tua yang dia sebut sebagai Faye dan Gene (nama samaran). Keluarga Westover tinggal di sebuah pertanian di pedesaan Idaho, tempat Gene mencari nafkah dengan menyelamatkan besi tua sementara Faye bekerja sebagai bidan dan tabib herbal tanpa izin. Gene menderita ketakutan paranoid terhadap campur tangan pemerintah federal, dan akibatnya dia menolak mengizinkan anak-anaknya bersekolah, menerima akta kelahiran, atau menerima perawatan medis. Gene juga seorang Mormon taat yang percaya pada kemandirian radikal dan Hari Penghakiman yang akan datang.\r\n\r\nPergeseran dalam dinamika keluarga Westover mulai terlihat ketika Tara berusia sekitar sembilan tahun. Pekerjaan ibunya sebagai bidan meningkatkan rasa kemandiriannya, namun setelah mengalami cedera otak yang serius dan tidak diobati dalam kecelakaan mobil, Faye mulai kehilangan kepercayaan pada keterampilannya, dan fokus pada penggunaan pengobatan herbal dan bentuk penyembuhan intuitif. Sekitar waktu ini, Tyler (putra ketiga) mengumumkan bahwa dia akan kuliah, yang membuatnya terasing dari keluarganya. Ketidakhadiran Tyler memaksa Tara untuk lebih terlibat dalam membantu ayahnya mengerjakan pekerjaan pembongkaran, yang membuatnya terus-menerus terkena kemungkinan cedera berbahaya. Hal ini juga membuatnya semakin penasaran untuk melanjutkan pendidikannya. Ketika Tara berusia sepuluh tahun, dia mengatakan kepada ayahnya yang tidak setuju bahwa dia ingin mulai bersekolah, tetapi tidak ada ide yang muncul.\r\n\r\nKetika Tara tumbuh remaja, dia memperoleh lebih banyak kemandirian dari keluarganya karena mengambil berbagai pekerjaan dan menekuni bidang menyanyi dan teater musikal di komunitas lokal. Namun, hidupnya didominasi oleh peraturan ketat dan doktrin agama yang diterapkan ayahnya, dan Tara sering kali khawatir akan menjadi berdosa. Ketika Tara berusia tiga belas tahun, kakak laki-lakinya Shawn pindah kembali ke rumah. Awalnya Shawn dan Tara dekat dan banyak menghabiskan waktu bersama. Namun, ketika Tara berusia sekitar lima belas tahun, Shawn mulai melakukan kekerasan fisik terhadapnya. Perilakunya semakin parah setelah Shawn mengalami cedera kepala. Tyler akhirnya menyadari bahwa Shawn menyakiti Tara, dan dia mendesak Tara untuk secara serius mempertimbangkan untuk mendaftar ke perguruan tinggi dan menjauh dari keluarga. Meskipun pada awalnya dia tidak yakin, Tara mulai belajar dan akhirnya diterima di Universitas Brigham Young, setelah menyatakan dirinya bersekolah di rumah.', 2),
(14, 8, 1, 'Pendidikan pada dasarnya bersifat retrospektif, terdiri dari kenangan Tara Westover tentang masa lalunya. Dia menceritakan kisah peristiwa-peristiwa dalam hidupnya dari sudut pandang di akhir usia dua puluhan, sesekali menyela untuk mengomentari proses mencoba mendapatkan versi masa lalu yang akurat. Tara lahir sebagai anak bungsu dari tujuh bersaudara dari orang tua yang dia sebut sebagai Faye dan Gene (nama samaran). Keluarga Westover tinggal di sebuah pertanian di pedesaan Idaho, tempat Gene mencari nafkah dengan menyelamatkan besi tua sementara Faye bekerja sebagai bidan dan tabib herbal tanpa izin. Gene menderita ketakutan paranoid terhadap campur tangan pemerintah federal, dan akibatnya dia menolak mengizinkan anak-anaknya bersekolah, menerima akta kelahiran, atau menerima perawatan medis. Gene juga seorang Mormon taat yang percaya pada kemandirian radikal dan Hari Penghakiman yang akan datang.\r\n\r\nPergeseran dalam dinamika keluarga Westover mulai terlihat ketika Tara berusia sekitar sembilan tahun. Pekerjaan ibunya sebagai bidan meningkatkan rasa kemandiriannya, namun setelah mengalami cedera otak yang serius dan tidak diobati dalam kecelakaan mobil, Faye mulai kehilangan kepercayaan pada keterampilannya, dan fokus pada penggunaan pengobatan herbal dan bentuk penyembuhan intuitif. Sekitar waktu ini, Tyler (putra ketiga) mengumumkan bahwa dia akan kuliah, yang membuatnya terasing dari keluarganya. Ketidakhadiran Tyler memaksa Tara untuk lebih terlibat dalam membantu ayahnya mengerjakan pekerjaan pembongkaran, yang membuatnya terus-menerus terkena kemungkinan cedera berbahaya. Hal ini juga membuatnya semakin penasaran untuk melanjutkan pendidikannya. Ketika Tara berusia sepuluh tahun, dia mengatakan kepada ayahnya yang tidak setuju bahwa dia ingin mulai bersekolah, tetapi tidak ada ide yang muncul.', 0);

-- --------------------------------------------------------

--
-- Table structure for table `statusbuku`
--

CREATE TABLE `statusbuku` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `statusbuku`
--

INSERT INTO `statusbuku` (`id`, `user_id`, `book_id`, `status`) VALUES
(3, 6, 5, 1),
(7, 6, 10, 1),
(8, 11, 1, 2),
(9, 11, 2, 2),
(10, 6, 11, 1),
(11, 8, 12, 1),
(12, 8, 13, 0),
(13, 9, 14, 0),
(14, 9, 15, 0);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `username` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `fullname`, `username`, `email`, `password`, `status`, `type`, `created_at`, `updated_at`) VALUES
(6, 'Amru Abid', 'abidzakly', 'abid@gmail.com', 'abid1234', 1, 1, '2023-12-25 12:12:13', '2023-12-27 02:50:07'),
(7, 'Nailan Nabil', 'nailann', 'nailan@gmail.com', 'nailan123', 1, 1, '2023-12-25 21:17:26', '2023-12-25 22:07:29'),
(8, 'Ica Aisyah', 'icaaisyah', 'ica@gmail.com', 'hani1234', 0, 1, '2023-12-25 21:17:56', '2023-12-25 22:07:22'),
(9, 'Fawwaz Maulana', 'fwzmaul', 'fwzmaul@gmail.com', 'fwz12345', 1, 1, '2023-12-25 22:02:42', '2023-12-25 22:07:16'),
(10, 'Zefanya Hashiolan', 'olanmanurung', 'olan@gmail.com', 'olan12345', 0, 1, '2023-12-25 22:07:02', '2023-12-25 22:07:02'),
(11, 'Muhtadi Yazid', 'muhtadi21', 'muhtadi@gmail.com', 'muhtadi123', 1, 2, '2023-12-26 05:11:43', '2023-12-26 15:56:42');

-- --------------------------------------------------------

--
-- Table structure for table `visited`
--

CREATE TABLE `visited` (
  `id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `visited`
--

INSERT INTO `visited` (`id`, `book_id`, `user_id`) VALUES
(1, 1, 9);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ringkasan`
--
ALTER TABLE `ringkasan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `book_id` (`book_id`);

--
-- Indexes for table `statusbuku`
--
ALTER TABLE `statusbuku`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_books_requests` (`book_id`),
  ADD KEY `fk_users_requests` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `visited`
--
ALTER TABLE `visited`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_users_visited` (`user_id`),
  ADD KEY `fk_books_visited` (`book_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `ringkasan`
--
ALTER TABLE `ringkasan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `statusbuku`
--
ALTER TABLE `statusbuku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `visited`
--
ALTER TABLE `visited`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ringkasan`
--
ALTER TABLE `ringkasan`
  ADD CONSTRAINT `ringkasan_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `ringkasan_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `buku` (`id`);

--
-- Constraints for table `statusbuku`
--
ALTER TABLE `statusbuku`
  ADD CONSTRAINT `fk_books_requests` FOREIGN KEY (`book_id`) REFERENCES `buku` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_users_requests` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `visited`
--
ALTER TABLE `visited`
  ADD CONSTRAINT `fk_books_visited` FOREIGN KEY (`book_id`) REFERENCES `buku` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_users_visited` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
