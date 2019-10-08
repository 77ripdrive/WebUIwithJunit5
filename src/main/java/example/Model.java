package example;

import java.util.Objects;

public class Model

{
    private String name;
    private String coast;

    public Model(String name, String coast)
    {
        this.name = name;
        this.coast = coast;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (!(o instanceof Model))
            return false;
        Model model = (Model) o;
        return name.equals(model.name) && coast.equals(model.coast);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, coast);
    }

    @Override
    public String toString()
    {
        return "Model{" + "name='" + name + '\'' + ", coast='" + coast + '\'' + '}';
    }
}
