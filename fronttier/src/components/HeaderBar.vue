<!-- src/components/HeaderBar.vue -->
<template>
  <header class="bg-green-900 text-white px-6 py-3 flex items-center justify-between">
    <!-- Left: Logo & Location -->
    <div class="flex items-center space-x-4">
      <h1 class="text-lg font-bold">ECR Farmer</h1>
      <div class="flex items-center space-x-1 text-sm">
        <img
          src="https://cdn-icons-png.flaticon.com/512/684/684908.png"
          alt="Map Icon"
          class="w-4 h-4"
        />
        <span>Delivering to <strong>Chennai</strong></span>
      </div>
    </div>

    <!-- Middle: Search -->
    <div class="flex-1 mx-6">
      <input
        type="text"
        placeholder="Search products..."
        class="w-full px-4 py-2 rounded-md text-black"
      />
    </div>

    <!-- Right: Cart & Login -->
    <div class="flex items-center space-x-6 text-sm">
      <router-link to="/cart" class="hover:underline">Cart</router-link>
      <router-link to="/login" class="hover:underline">Login / Signup</router-link>
    </div>
  </header>
</template>
