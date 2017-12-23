import java.io.File
import java.io.InputStream
import java.lang.Math.abs

class DayTwenty {

    fun solve(path: String) : Int  {
        val inStream : InputStream = File(path).inputStream()
        val inputAsString = inStream.bufferedReader().use { it.readText() }
        val regex = Regex("""-?\d+""")
        val particles = inputAsString.lines()
                .map { regex.findAll(it) }
                .map { it.map { it.value.toLong() } }
                .map { it.chunked(3) }
                .map { it.map { (x, y, z) -> Vec3(x, y, z) } }
                .map { it.toList() }
                .map { (p, v, a) -> Particle(p, v, a) }
                .toMutableList()

       repeat(1000) {
            particles.forEach(Particle::update)
        }

        return particles.withIndex().minBy { it.value.distance() }!!.index
    }

    fun solve2(path: String) : Int {
        val inStream : InputStream = File(path).inputStream()
        val inputAsString = inStream.bufferedReader().use { it.readText() }
        val regex = Regex("""-?\d+""")
        val particles = inputAsString.lines()
                .map { regex.findAll(it) }
                .map { it.map { it.value.toLong() } }
                .map { it.chunked(3) }
                .map { it.map { (x, y, z) -> Vec3(x, y, z) } }
                .map { it.toList() }
                .map { (p, v, a) -> Particle(p, v, a) }
                .toMutableList()

        repeat (1000) {
            particles.forEach(Particle::update)
            particles.groupBy(Particle::p)
                    .values
                    .filter { it.size > 1 }
                    .forEach { ps -> particles.removeAll(ps) }
        }

        return particles.size
    }

    data class Particle(var p: Vec3, var v: Vec3, val a: Vec3) {
        fun update() {
            v += a
            p += v
        }

        fun distance() = sequenceOf(p.x, p.y, p.z).map(::abs).sum()
    }

    data class Vec3(val x: Long, val y: Long, val z: Long) {
        operator fun plus(other: Vec3) = Vec3(x + other.x, y + other.y, z + other.z)
    }
}