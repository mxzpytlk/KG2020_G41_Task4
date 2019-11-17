/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task4threedimensions.draw;

/**
 *
 * @author Alexey
 */
public interface IFilter<T> {
    boolean permit(T value);
}
