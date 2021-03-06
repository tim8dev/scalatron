package scalatron.scalatron.impl

import FileUtil.deleteRecursively
import scalatron.scalatron.api.Scalatron
import Scalatron.SourceFile
import Scalatron.SourceFileCollection



case class ScalatronSample(name: String, scalatron: ScalatronImpl) extends Scalatron.Sample {
    val sampleDirectoryPath = scalatron.samplesBaseDirectoryPath + "/" + name
    val sampleSourceDirectoryPath = sampleDirectoryPath + "/" + Scalatron.Constants.SamplesSourceDirectoryName

    def sourceFiles: Iterable[SourceFile] = SourceFileCollection.loadFrom(sampleSourceDirectoryPath)

    def delete() { deleteRecursively(sampleDirectoryPath, scalatron.verbose) }
}
