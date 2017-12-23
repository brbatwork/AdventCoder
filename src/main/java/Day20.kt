import java.io.File
import java.io.InputStream

class Particle(val id: Int, val pointRaw : List<String>, val vectorRaw : List<String>, val accRaw: List<String>) {
    val point = mutableListOf<Long>()
    val vector = mutableListOf<Long>()
    val acceleration = mutableListOf<Long>()

    init {
        convertRawPoints(point, pointRaw)
        convertRawPoints(vector, vectorRaw)
        convertRawPoints(acceleration, accRaw)
    }

    override fun toString(): String {
        return "id:$id : p:$point v:$vector a:$acceleration"
    }

    private fun convertRawPoints(output : MutableList<Long>, raw : List<String>) {
        raw.forEach {
            val v = it.trim().trim('>')
            if (v.startsWith('a') || v.startsWith('p') || v.startsWith('v')) {
                output.add(v.substring(3).toLong())
            } else {
                output.add(v.toLong())
            }
        }
    }

    fun totalAcceleration() : Long {
        return acceleration.map {Math.abs(it)}.sum()
    }

    fun tick() {
        vector[0] += acceleration[0]
        vector[1] += acceleration[1]
        vector[2] += acceleration[2]

        point[0] += vector[0]
        point[1] += vector[1]
        point[2] += vector[2]
    }
}

class Day20 {
    fun part1(path: String) : Int {
        val inStream : InputStream = File(path).inputStream()
        val particles = mutableListOf<Particle>()
        var idx = 0

        inStream.bufferedReader().useLines { lines -> lines.forEach {
            val parts = it.split(">,")
            val pointData = parts[0].split(",")
            val vectorData = parts[1].split(",")
            val accData = parts[2].split(",")
            particles.add(Particle(idx, pointData, vectorData, accData))
            idx++
        }}

        var leastDistance = Int.MAX_VALUE.toLong()
        var leastPoint : Particle = Particle(0, listOf(), listOf(), listOf())

        for (particle in particles) {
            val total= particle.totalAcceleration()
            if (total <= leastDistance) {
                leastDistance = total
                leastPoint = particle
            }
        }
        return leastPoint.id
    }
}
