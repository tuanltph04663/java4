<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<!-- include head.jsp -->
<%@include file="common/_head.jsp"%>

<body>
	<!-- include header.jsp -->
	<%@include file="common/_header.jsp"%>

	<div id="wrapper">
		<!-- include sidebar.jsp -->
		<%@include file="common/_sidebar.jsp"%>
		
		<div id="rightContent">
			<h3>Dashboard</h3>
			<div class="quoteOfDay">
				<b>Quote of the day :</b><br> <i style="color: #5b5b5b;">"If
					you think you can, you really can"</i>
			</div>
			<div class="shortcutHome">
				<a href=""><img src="mos-css/img/posting.png"><br>Tambah
					Posting</a>
			</div>
			<div class="shortcutHome">
				<a href=""><img src="mos-css/img/photo.png"><br>Upload
					Foto</a>
			</div>
			<div class="shortcutHome">
				<a href=""><img src="mos-css/img/halaman.png"><br>Tambah
					Halaman</a>
			</div>
			<div class="shortcutHome">
				<a href=""><img src="mos-css/img/template.png"><br>Pengaturan
					Template</a>
			</div>
			<div class="shortcutHome">
				<a href=""><img src="mos-css/img/quote.png"><br>Tambah
					QOD</a>
			</div>
			<div class="shortcutHome">
				<a href=""><img src="mos-css/img/bukutamu.png"><br>Data
					Buku Tamu</a>
			</div>

			<div class="clear"></div>

			<div id="smallRight">
				<h3>Informasi web anda</h3>
				<table
					style="border: none; font-size: 12px; color: #5b5b5b; width: 100%; margin: 10px 0 10px 0;">
					<tr>
						<td style="border: none; padding: 4px;">Jumlah posting</td>
						<td style="border: none; padding: 4px;"><b>12</b></td>
					</tr>
					<tr>
						<td style="border: none; padding: 4px;">Jumlah kategori</td>
						<td style="border: none; padding: 4px;"><b>12</b></td>
					</tr>
					<tr>
						<td style="border: none; padding: 4px;">Jumlah komentar
							diterbitkan</td>
						<td style="border: none; padding: 4px;"><b>12</b></td>
					</tr>
					<tr>
						<td style="border: none; padding: 4px;">Jumlah komentar belum
							diterbitkan</td>
						<td style="border: none; padding: 4px;"><b>12</b></td>
					</tr>
					<tr>
						<td style="border: none; padding: 4px;">Jumlah foto dalam
							galeri</td>
						<td style="border: none; padding: 4px;"><b>12</b></td>
					</tr>
					<tr>
						<td style="border: none; padding: 4px;">Jumlah data buku tamu</td>
						<td style="border: none; padding: 4px;"><b>12</b></td>
					</tr>
				</table>
			</div>
			<div id="smallRight">
				<h3>Statistik pengunjung web</h3>

				<table
					style="border: none; font-size: 12px; color: #5b5b5b; width: 100%; margin: 10px 0 10px 0;">
					<tr>
						<td style="border: none; padding: 4px;">Pengunjung online</td>
						<td style="border: none; padding: 4px;"><b>12</b></td>
					</tr>
					<tr>
						<td style="border: none; padding: 4px;">Pengunjung hari ini</td>
						<td style="border: none; padding: 4px;"><b>12</b></td>
					</tr>
					<tr>
						<td style="border: none; padding: 4px;">Total pengunjung</td>
						<td style="border: none; padding: 4px;"><b>12</b></td>
					</tr>
					<tr>
						<td style="border: none; padding: 4px;">Hit hari ini</td>
						<td style="border: none; padding: 4px;"><b>12</b></td>
					</tr>
					<tr>
						<td style="border: none; padding: 4px;">Total hit</td>
						<td style="border: none; padding: 4px;"><b>12</b></td>
					</tr>
				</table>
			</div>
		</div>
		
		<!-- include footer.jsp -->
		<%@include file="common/_footer.jsp"%>
	</div>
</body>
</html>