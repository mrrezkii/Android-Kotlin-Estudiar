package com.esdgabut.estudiar.utils

import com.esdgabut.estudiar.data.model.ReviewModel
import com.esdgabut.estudiar.data.model.TentorModel
import java.util.*

fun createTentor(): TentorModel {
    return createTentors()[0]
}

fun createTentors(): List<TentorModel> {
    val tentors = ArrayList<TentorModel>()
    tentors.add(
        TentorModel(
            name = "Muhammad Alfian Gibran",
            latar_belakang = "Saya merupakan mahasiswa lulusan S1 Pendidikan di salahsatu universitas indonesia. sejak di bangku kuliah saya aktif di kegiatan di bidang sosial dan pendidikan. namun mulai aktif mengajar setelah 2 tahun kuliah. dan masuk ke dunia profesional pada saat lulus kuliah.",
            url = "https://caritentor.com/wp-content/uploads/2020/05/20200529_131754.jpg"
        )
    )
    tentors.add(
        TentorModel(
            name = "Ghea Firsty Nur Madani",
            latar_belakang = "Saya merupakan mahasiswa lulusan S1 sosial ekonomi di salahsatu universitas indonesia. sejak di bangku kuliah saya aktif mengikuti volunteer di komunitas social khususnya di bidang sosial dan pendidikan. namun mulai aktif mengajar setelah berada di semester akhir  kuliah. dan masuk ke dunia profesional pada saat lulus kuliah.",
            url = "https://caritentor.com/wp-content/uploads/2020/11/F95A4B03-5E58-4B52-BA12-8CD39339BA74-150x150.jpeg"
        )
    )
    tentors.add(
        TentorModel(
            name = "Rizki Nur Fajriyani",
            latar_belakang = "Saya merupakan mahasiswa lulusan S1 Pendidikan di salahsatu universitas indonesia. sejak di bangku kuliah saya aktif di kegiatan di kampus pada bidang sosial dan pendidikan. namun mulai aktif mengajar setelah lulus kuliah dan masuk ke dunia profesional pada saat 2 tahun lulus kuliah",
            url = "https://i1.rgstatic.net/ii/profile.image/618676990517249-1524515497187_Q512/Rizki-Nur-Fajriyani.jpg"
        )
    )
    tentors.add(
        TentorModel(
            name = "Sena Juang",
            latar_belakang = "Saya merupakan mahasiswa lulusan S1 Public Relation di salahsatu universitas indonesia. sejak di bangku kuliah saya aktif mengikuti kegiatan di bidang student exchange. namun mulai aktif mengajar setelah berada di semester akhir  kuliah, namun belum masuk ke dunia profesional",
            url = "https://caritentor.com/wp-content/uploads/2020/08/163221180-mhs-personal-1-600x600.jpg"
        )
    )
    tentors.add(
        TentorModel(
            name = "Desi Pitria",
            latar_belakang = "Saya merupakan mahasiswa lulusan S1 Pendidikan di salahsatu universitas indonesia. sejak di bangku kuliah saya aktif di volunteer pada bidang pendidikan. namun mulai aktif mengajar setelah 3 tahun kuliah. dan masuk ke dunia profesional pada saat lulus kuliah",
            url = "https://pbs.twimg.com/profile_images/1380921551264997380/F37RBZL9.jpg"
        )
    )
    tentors.add(
        TentorModel(
            name = "Mukhlis Kurniawan",
            latar_belakang = "Saya merupakan mahasiswa lulusan S1 Informatika di salahsatu universitas indonesia. sejak di bangku kuliah saya aktif mengikuti kompetisi di bidang pemograman. namun mulai aktif mengajar setelah berada di semester akhir  kuliah pada saat kegiatan himpunan di universitas.",
            url = "https://pbs.twimg.com/profile_images/578634178511515648/vw6VDoK-.jpeg"
        )
    )
    tentors.add(
        TentorModel(
            name = "Nasihun Amin",
            latar_belakang = "Saya merupakan mahasiswa lulusan S1 FISIKA di salahsatu universitas indonesia. sejak di bangku kuliah saya aktif kegiatan lab dan riset di bidang teknologi. namun mulai aktif mengajar setelah lulus kuliah, karna saya merasa dengan membagikan ilmu yang kita dapatkan kepada orang lain",
            url = "https://qph.fs.quoracdn.net/main-thumb-242913308-200-tbyyvbmzgphctzxfqkopahgtlfhiivbq.jpeg"
        )
    )
    tentors.add(
        TentorModel(
            name = "Matheus Nugroho",
            latar_belakang = "Saya merupakan mahasiswa lulusan S1 matematika di salahsatu universitas indonesia. sejak di bangku kuliah saya aktif mengikuti project bareng dosen dan kompetisi di bidang pemograman. namun mulai aktif mengajar setelah berada di salah satu komunitas di kota saya tempati sekarang.",
            url = "https://anggota.igi.or.id/image/profil/besar/user-695392857296355-fb-Nasihun%20Amin.jpg"
        )
    )
    tentors.add(
        TentorModel(
            name = "Mamnuah Mamnuah",
            latar_belakang = "Saya merupakan mahasiswa lulusan S1 Fisika di salahsatu universitas indonesia. sejak di bangku kuliah saya aktif mengikuti kompetisi dan pengabdian masyarakat dalam tujuan mengajar. namun mulai aktif mengajar setelah berada di semester akhir  kuliah pada saat kegiatan himpunan di universitas.",
            url = "https://caritentor.com/wp-content/uploads/2020/10/IMG_2609-600x450.jpg"
        )
    )
    return tentors
}

fun createReviews(): List<ReviewModel> {
    val review = ArrayList<ReviewModel>()
    review.add(ReviewModel(review = "Suka banget sama tentornya ini", score = 5.0, name = "Abdoel"))
    review.add(ReviewModel(review = "Tentornya wibu pars", score = 4.8, name = "Hakuu"))
    review.add(
        ReviewModel(
            review = "Cara ngajarnya gampang, saya suka",
            score = 4.4,
            name = "Erna Ananda"
        )
    )
    review.add(
        ReviewModel(
            review = "Bang, request wagyu A5",
            score = 5.0,
            name = "Waluyo Mahmudin"
        )
    )
    return review
}