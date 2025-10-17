#include <iostream>
#include <vector>
#include <climits>
#include <cstring>

using namespace std;

int n;
int dist[10][10];
bool visited[10];
int minCost = INT_MAX;
vector<int> bestPath;
vector<int> path;

void dfs(int currentCity, int count, int cost) {
    if (count == n) {
        cost += dist[currentCity][0];
        if (cost < minCost) {
            minCost = cost;
            bestPath = path;
            bestPath.push_back(0);
        }
        return;
    }

    for (int nextCity = 0; nextCity < n; ++nextCity) {
        if (!visited[nextCity]) {
            visited[nextCity] = true;
            path.push_back(nextCity);
            dfs(nextCity, count + 1, cost + dist[currentCity][nextCity]);
            visited[nextCity] = false;
            path.pop_back();
        }
    }
}

int main() {
    n = 4;
    int tempDist[4][4] = {
        {0, 10, 15, 20},
        {10, 0, 35, 25},
        {15, 35, 0, 30},
        {20, 25, 30, 0}
    };

    memcpy(dist, tempDist, sizeof(dist));
    memset(visited, false, sizeof(visited));

    visited[0] = true;
    path.push_back(0);

    dfs(0, 1, 0);

    cout << minCost << "\n";
    for (int city : bestPath) {
        cout << city;
    }
    cout << endl;

    return 0;
}
