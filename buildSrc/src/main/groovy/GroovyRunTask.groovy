import org.gradle.api.tasks.JavaExec;
import org.gradle.api.Task;

class GroovyRunTask extends JavaExec {

    public Task configure(Closure closure) {
        setClasspath(project.sourceSets.main.runtimeClasspath)
        super.configure(closure)
    }
}
